package mx.edu.itl.c17130804.juegoelgatoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class WinnerActivity extends AppCompatActivity {
    TextView ganador;
    ImageView img;
    String nombre = "";
    String nombrej1="",nombrej2="",color="";
    int select;
    int imgganador;
    String Alrato_la_quito ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        nombre = b.getString("nombre" );
        imgganador = b.getInt("imgganador");
        ganador = findViewById( R.id.txtvNombreGanador );
        nombrej1 = b.getString("nombrej1");
        nombrej2 = b.getString( "nombrej2" );
        color = b.getString( "color" );
        select = b.getInt( "select" );

        img = findViewById( R.id.imgGanador );
        ganador.setText(nombre);
        img.setImageResource(imgganador);
    }

    public void btnrevanchaclick ( View v ){
        Intent intent = new Intent( WinnerActivity.this , MainActivity.class );
        intent.putExtra("nombre1" , nombrej1 );
        intent.putExtra("nombre2" , nombrej2 );
        intent.putExtra( "select" , select);
        intent.putExtra( "color" , color);
        startActivity( intent );
        finish();

    }

    public void btniniciardenuevoclick ( View v ){
    Intent intent = new Intent( WinnerActivity.this , Personalizar.class );
    startActivity( intent );
    finish();

    }

    public void btnmenuprincipalclick ( View v ){
        Intent intent = new Intent( WinnerActivity.this , Menu.class );
        startActivity( intent );
        finish();

    }
}