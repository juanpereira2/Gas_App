package ser.unama.po3_gasapp_7bcma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class Tela1 extends AppCompatActivity {
    private EditText txt_Modelo;
    private EditText txt_Distancia;
    private EditText txt_Potencia;
    private EditText txt_Gasolina;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1);
        //integração entre xml e java
        txt_Modelo=findViewById(R.id.edit_Modelo);
        txt_Distancia=findViewById(R.id.edit_Distancia);
        txt_Potencia=findViewById(R.id.edit_Potencia);
        txt_Gasolina=findViewById(R.id.edit_Gasolina);
    }//fim do on criate
    private void calcular() {
        //pegar valores
        String modeloDigitado = txt_Modelo.getText().toString();
        String distDigitado = txt_Distancia.getText().toString();
        String potDigitado = txt_Potencia.getText().toString();
        String gasDigitado = txt_Gasolina.getText().toString();
        //converter valores
        double distancia = Double.valueOf(distDigitado);
        double potencia = Double.valueOf(potDigitado);
        double gasolina = Double.valueOf(gasDigitado);

        //realizar o calculo
        double valorPotencia = 0.0;
         if(potencia<=1.0){  valorPotencia=13.0;
         }else if (potencia >1.0 && potencia <= 1.4) {
             valorPotencia = 11.00;
         }else if (potencia >1.4 && potencia <= 1.9) {
             valorPotencia = 9.5;
         }else {
             valorPotencia = 7.75;
         }

    double total = (distancia / valorPotencia)* gasolina;
    Intent i = new Intent(this ,Tela2.class);
    i.putExtra("MODELO",modeloDigitado);
    i.putExtra("DISTANCIA",distancia);
    i.putExtra("POTENCIA",potencia);
    i.putExtra("GASOLINA",gasolina);
    i.putExtra("TOTAL", total);

    startActivity(i);


                    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tela1,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       int itemClicado = item.getItemId();
       if(itemClicado == R.id.menu_calcular){
           calcular( );
       }
        return super.onOptionsItemSelected(item);
    }
}// fim da classe
