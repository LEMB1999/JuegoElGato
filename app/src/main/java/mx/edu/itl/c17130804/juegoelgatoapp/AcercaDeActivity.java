/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2020    HORA: 2:25 HRS
:*
:*                       Clase para mostrar el layout acerca de
:*
:*  Archivo     : AcercaDeActivity.java
:*  Autor       : Maniacorp
:*  Fecha       : 05/12/2020
:*  Compilador  : Android Studio 4.0.1
:*  Descripción : Clase para mostrar el layout acerca de y ver asi la portada del equipo
:*  Ultima modif:
:*  Fecha       Modificó                 Motivo
:*==========================================================================================
:*  05/12/2020  Jose Angel Garcia Arce   Documentar la aplicación
:*------------------------------------------------------------------------------------------*/
package mx.edu.itl.c17130804.juegoelgatoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

//-------------------------------------------------------------------------------------------------

public class AcercaDeActivity extends AppCompatActivity {

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState ) ;
        setContentView ( R.layout.activity_acerca_de ) ;
    }
}