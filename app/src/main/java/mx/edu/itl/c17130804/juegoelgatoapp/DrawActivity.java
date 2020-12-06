/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2020    HORA: 2:25 HRS
:*
:*                  Clase para cuando exite un empate en modo multijugador (Draw)
:*
:*  Archivo     : DrawActivity.java
:*  Autor       : Maniacorp
:*  Fecha       : 05/12/2020
:*  Compilador  : Android Studio 4.0.1
:*  Descripción : Clase utilizada para cuando suceda un empate en el modo multijugador
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

//-------------------------------------------------------------------------------------------------

public class DrawActivity extends AppCompatActivity {
    TextView ganador;
    ImageView img;
    String nombre = "";
    String nombrej1="",nombrej2="",color="Rojo";
    int select;

//-------------------------------------------------------------------------------------------------
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState ) ;
        setContentView ( R.layout.activity_draw ) ;
        Intent intent = getIntent ( ) ;
        Bundle b = intent.getExtras ( ) ;
        nombrej1 = b.getString ("nombrej1" ) ;
        nombrej2 = b.getString ( "nombrej2"  ) ;
        select = b.getInt ( "select" ) ;
        color = b.getString ("color" );

    }

//--------------------------------------------------------------------------------------------------
    public void btnRevancha( View v ){
        Intent intent = new Intent ( DrawActivity.this , MainActivity.class ) ;
        intent.putExtra ("nombre1" , nombrej1 ) ;
        intent.putExtra ("nombre2" , nombrej2 ) ;
        intent.putExtra ( "select" , select);
        intent.putExtra ( "color" , color);
        startActivity ( intent ) ;
        finish ( ) ;

    }
//-------------------------------------------------------------------------------------------------
    public void btnDeNuevo ( View v ){
        Intent intent = new Intent ( DrawActivity.this , Personalizar.class ) ;
        startActivity ( intent );
        finish ( ) ;

    }
//-------------------------------------------------------------------------------------------------
    public void btnmenuprincipalclick ( View v ){
        Intent intent = new Intent( DrawActivity.this, Menu.class );
        startActivity( intent );
        finish ( ) ;

    }
}