/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2020    HORA: 2:25 HRS
:*
:*              Clase utilizada para mostrar la ventana de ganador en modo multiplayer

:*  Archivo     : WinnerActivity.java
:*  Autor       : Maniacorp
:*  Fecha       : 05/12/2020
:*  Compilador  : Android Studio 4.0.1
:*  Descripción : Clase utilizada para mostrar la ventana de ganador en modo multiplayer
:*  Ultima modif:
:*  Fecha       Modificó                 Motivo
:*==========================================================================================
:*  05/12/2020  Jose Angel Garcia Arce   Documentar la aplicación
:*------------------------------------------------------------------------------------------*/
package mx.edu.itl.c17130804.juegoelgatoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class WinnerActivityJ1 extends AppCompatActivity {
    TextView ganador;
    ImageView img;
    String nombre = "";
    String nombrej1="",nombrej2="",color="";
    int select;
    int imgganador;
    String Alrato_la_quito ;
//-------------------------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner_j1);
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
    //----------------------------------------------------------------------------------------------
    public void btnrevanchaclick ( View v ){
        Intent intent = new Intent( WinnerActivityJ1.this , UnJugadorActivity.class );
        intent.putExtra("nombre1" , nombrej1 );
        intent.putExtra("nombre2" , nombrej2 );
        intent.putExtra( "select" , select);
        intent.putExtra( "color" , color);
        startActivity( intent );
        finish();

    }
    //-----------------------------------------------------------------------------------------------
    public void btnmenuprincipalclick ( View v ){
        Intent intent = new Intent( WinnerActivityJ1.this , Menu.class );
        startActivity( intent );
        finish();

    }
}