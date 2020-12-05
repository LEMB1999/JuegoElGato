package mx.edu.itl.c17130804.juegoelgatoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DrawActivity2 extends AppCompatActivity {

    TextView ganador;
    ImageView img;
    String nombre = "";
    String nombrej1="",nombrej2="",color="Rojo";
    int select;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw2);
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        nombrej1 = b.getString("nombrej1");
        nombrej2 = b.getString( "nombrej2" );
        select = b.getInt( "select" );
        color = b.getString("color");

    }


    public void btnRevancha( View v ){
        Intent intent = new Intent( DrawActivity2.this , MainActivity.class );
        intent.putExtra("nombre1" , nombrej1 );
        intent.putExtra("nombre2" , nombrej2 );
        intent.putExtra( "select" , select);
        intent.putExtra( "color" , color);
        startActivity( intent );
        finish();

    }




    public void btnmenuprincipalclick ( View v ){
        Intent intent = new Intent( DrawActivity2.this, Menu.class );
        startActivity( intent );
        finish();

    }
}