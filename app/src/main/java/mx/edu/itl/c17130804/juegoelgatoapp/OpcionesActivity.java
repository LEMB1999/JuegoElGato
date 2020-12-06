/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2020    HORA: 2:25 HRS
:*
:*            Clase utilizada para mostrar las opciones como cabiar el idioma y acerca de
:*
:*  Archivo     : OpcionesActivity.java
:*  Autor       : Maniacorp
:*  Fecha       : 05/12/2020
:*  Compilador  : Android Studio 4.0.1
:*  Descripción : Clase utilizada para seleccionar el idioma y el acerca de
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

public class OpcionesActivity extends AppCompatActivity {
//--------------------------------------------------------------------------------------------------
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState ) ;
        setContentView ( R.layout.activity_opciones ) ;
    }
    //----------------------------------------------------------------------------------------------
    public void btnAcercaDeClick ( View v ){
        Intent intent = new Intent (OpcionesActivity.this , AcercaDeActivity.class ) ;
        startActivity ( intent ) ;
    }
}