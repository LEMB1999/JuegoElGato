package mx.edu.itl.c17130804.juegoelgatoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.util.ArrayList;

public class Personalizar extends AppCompatActivity {

    //declarar las referencias de los componentes
        EditText edtj1 , edtj2;
        RadioButton rbntj1 ,rbtnj2;
        Spinner spnColores;
        int select = 0;
        ArrayList<String> As = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalizar);
        edtj1 = findViewById( R.id.edtJugador1 );
        edtj2 = findViewById( R.id.edtJugador2 );
        rbntj1 = findViewById( R.id.rdbtnjugador1 );
        rbtnj2 = findViewById( R.id.rdbtnjugador2 );
        spnColores = findViewById( R.id.spnColores );
        As.add(0,"Rojo");
        As.add(1,"Naranja");
        As.add(2,"Verde");
        As.add(3,"Azul");

        ColorAdapter adaptador = new ColorAdapter( this , As );
        adaptador.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
        spnColores.setAdapter( adaptador );

    }


    public void btnplayclick ( View v ){
        if(rbntj1.isChecked())
            select = 0;
        else if (rbtnj2.isChecked())
            select = 1;


        Intent intent = new Intent( Personalizar.this , MainActivity.class );
        intent.putExtra("nombre1" , edtj1.getText().toString() );
        intent.putExtra("nombre2" , edtj2.getText().toString() );
        intent.putExtra( "select" , select);
        intent.putExtra( "color" , spnColores.getSelectedItem().toString());
        startActivity( intent );
        finish();
    }
}