package ser.unama.po3_gasapp_7bcma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Tela2 extends AppCompatActivity {
        private TextView txtResultado;
        private String modelo;
        private double distancia,gasolina,potencia,total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);
       txtResultado = findViewById(R.id.tela2_resultado);
        Intent j = getIntent();
        modelo = j.getStringExtra("MODELO");
        distancia = j.getDoubleExtra("DISTANCIA",0.0);
        potencia = j.getDoubleExtra("POTENCIA",0.0);
        gasolina = j.getDoubleExtra("GASOLINA",0.0);
        total = j.getDoubleExtra("TOTAL",0.0);
        DecimalFormat df = new DecimalFormat("#.00");

        txtResultado.setText("O carro " + modelo+ " com o motor de " + potencia + " de potencia, gasta em R$ " +
                "" + df.format( total ) + " para correr a distancia de " + distancia + " km com gasolina a R$ " +
                gasolina + " por litro " + " \n \n "+ "Criado pelo app do Juan :) " );

    }
        private void compartilhar() {
        Intent k = new Intent(Intent.ACTION_SEND);
        k.setType("text/plain");
        k.putExtra(Intent.EXTRA_SUBJECT,"gasapp");
        k.putExtra(Intent.EXTRA_TEXT,txtResultado.getText().toString());
        startActivity(Intent.createChooser(k ,"Compartilhar"));
        }
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu_tela2,menu);
            return true;
        }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemClicado = item.getItemId();
        if(itemClicado == R.id.menu_compartilhar){
            compartilhar();
        }
        return super.onOptionsItemSelected(item);

    }
}
