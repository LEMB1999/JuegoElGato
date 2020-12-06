/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2020    HORA: 2:25 HRS
:*
:*              Clase utilizada para el modo 1 player

:*  Archivo     : UnJugadorActivity.java
:*  Autor       : Maniacorp
:*  Fecha       : 05/12/2020
:*  Compilador  : Android Studio 4.0.1
:*  Descripción : Clase utilizada para crear el modo un jugador
:*  Ultima modif:
:*  Fecha       Modificó                 Motivo
:*==========================================================================================
:*  05/12/2020  Jose Angel Garcia Arce   Documentar la aplicación
:*------------------------------------------------------------------------------------------*/
package mx.edu.itl.c17130804.juegoelgatoapp;


import android.content.Intent;
import android.os.Bundle;
import com.bumptech.glide.Glide;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class UnJugadorActivity extends AppCompatActivity {


    TextView text;
    String nombrej1 = "Jugador 1" , nombrej2 = "CPU" , color = "Rojo";
    ArrayList<ImageView> arr , arraux;
    int  ids[];
    ArrayList<Integer>  arr_valores;
    View x;
    int turno = 0 , aux ;
    int num_turnos = 0;
    int cells = 9;
    int coordenadas [][] = { {0,1,2},{0,3,6},{2,5,8},{6,7,8},{0,4,8},{2,4,6},{1,4,7},{3,4,5}};
    int circulo , tacha, r;
    Random azar = new Random();
    //----------------------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inicializar atributos
        tacha = R.drawable.tacharojo ;
        circulo   = R.drawable.circulonaranja;
        arr = new ArrayList<>(9);
        text = findViewById(R.id.txtJugador);
        arr_valores = new ArrayList<Integer>( Arrays.asList(-1,-1,-1,-1,-1,-1,-1,-1,-1));
        ids = new int[9];

        ids[0] = R.id.img1;
        ids[1] = R.id.img2;
        ids[2] = R.id.img3;
        ids[3] = R.id.img4;
        ids[4] = R.id.img5;
        ids[5] = R.id.img6;
        ids[6] = R.id.img7;
        ids[7] = R.id.img8;
        ids[8] = R.id.img9;

        for (int i = 0; i < 9 ; i++) {
            arr.add(findViewById(ids[i]));
        }

    }


    //----------------------------------------------------------------------------------------------
    //Metodo que se utiliza para el cambio de imagen medinte el Glide ya sea una X o un O
    public void  cambiar_imagen(int id, int turno){
        ImageView img = findViewById(id);
        if( turno == 0){
            Glide.with(this).load(tacha).into(img);

        }else{
            Glide.with(this).load(circulo).into(img);
        }
    }

    //----------------------------------------------------------------------------------------------
    //Metodo para cambiar de turno y a su vez realizar toda la funcion principal de la app
    public void cambiar_imagen(View view){

        if( turno == 0){
            text.setText(nombrej2);
        }else{
            text.setText(nombrej1);
        }

        actualiza_arreglo(view.getId(),turno);
        cambiar_imagen(view.getId(),turno);
        turno = turno == 0?1:0;
        boolean flag1 = false,flag2 = false;
        if(num_turnos == 8 ){
            flag1 = verificar_ganador(0);
            flag2 = verificar_ganador(1);
            Intent intent = new Intent(UnJugadorActivity.this, DrawActivity2.class);
            intent.putExtra("nombrej1", nombrej1);
            intent.putExtra("nombrej2", nombrej2);
            intent.putExtra("Select", aux);
            intent.putExtra("color", color);
            startActivity(intent);
            finish();
        }else
        if (num_turnos>=4){
            flag1 = verificar_ganador(0);
            flag2 = verificar_ganador(1);
        }
            num_turnos++;

        //desactivar boton
        view.setEnabled(false);
        ganador(flag1,flag2);

        Log.d("posicion:" ,""+r);


        disponibles();
        CPU(x);
    }
    //----------------------------------------------------------------------------------------------
    //Metodo para hacer posible el jugar contra la computadora que
    public void CPU(View view ){
        if( turno == 0){
            text.setText(nombrej2);
        }else{
            text.setText(nombrej1);
        }

        actualiza_arreglo(view.getId(),turno);
        cambiar_imagen(view.getId(),turno);
        turno = turno == 0?1:0;
        boolean flag1 = false,flag2 = false;
        if(num_turnos == 8 ){
            flag1 = verificar_ganador(0);
            flag2 = verificar_ganador(1);
            Intent intent = new Intent(UnJugadorActivity.this, DrawActivity2.class);
            intent.putExtra("nombrej1", nombrej1);
            intent.putExtra("nombrej2", nombrej2);
            intent.putExtra("Select", aux);
            intent.putExtra("color", color);
            startActivity(intent);
            finish();
        }else
        if (num_turnos >= 4){
            flag1 = verificar_ganador(0);
            flag2 = verificar_ganador(1);
        }
            num_turnos++;

        //desactivar boton
        view.setEnabled(false);
        ganador(flag1,flag2);

    }




    //----------------------------------------------------------------------------------------------
    public void actualiza_arreglo(int id,int turno){
        if( id == ids[0] ){
            arr_valores.set(0,turno);
        }else if( id == ids[1] ){
            arr_valores.set(1,turno);
        }else if( id == ids[2] ){
            arr_valores.set(2,turno);
        }else if( id == ids[3] ){
            arr_valores.set(3,turno);
        }else if( id == ids[4] ){
            arr_valores.set(4,turno);
        }else if( id == ids[5] ){
            arr_valores.set(5,turno);
        }else if( id == ids[6] ){
            arr_valores.set(6,turno);
        }else if( id == ids[7] ){
            arr_valores.set(7,turno);
        }else if( id == ids[8] ){
            arr_valores.set(8,turno);
        }
    }

    //----------------------------------------------------------------------------------------------
    //Metodo para verificar ganador el cual checa si se cumplen las 3 posiciones adecuadas para la
    //victria
    public boolean verificar_ganador(int jugador){
        Log.d("datos",arr_valores.toString());
        int acomulador;
        for (int i = 0; i<8; i++){
            acomulador = 0;
            for (int j = 0; j < 3; j++){
                if( jugador == arr_valores.get(coordenadas[i][j]) ){
                    acomulador++;
                }
            }
            if(acomulador == 3){
                return true;
            }
        }
        return false;

    }
    //----------------------------------------------------------------------------------------------
    //Metodo para desactivar botones
    public void desactivar_botones(){
        for( int i = 0; i<arr.size();i++){
            arr.get(i).setEnabled(false);
        }
    }

    //----------------------------------------------------------------------------------------------
    //Metodo que checa los botonoes que aun estan disponibles y asi generar un numero aleatorio de los mismos
    public void disponibles(){
        arraux = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            if(arr.get(i).isEnabled())
                arraux.add(arr.get(i));
        }
        if(!arraux.isEmpty()) {
            r = azar.nextInt(arraux.size());
            x = arraux.get(r);
        }else{
            //Toast.makeText(this ,"Queda 1", Toast.LENGTH_LONG).show();
        }

    }
    //----------------------------------------------------------------------------------------------
    //Metodo que determina el ganador mediante las vanderas que utilizan el metodo verificar ganador
    public void ganador ( boolean flag1 , boolean flag2 ){

        if(flag1){
            Intent intent = new Intent( UnJugadorActivity.this , WinnerActivityJ1.class );
            intent.putExtra( "nombre" , nombrej1 );
            intent.putExtra("imgganador", aux==0?tacha:circulo);
            intent.putExtra("nombrej1" , nombrej1);
            intent.putExtra( "nombrej2",nombrej2);
            intent.putExtra("Select", aux);
            intent.putExtra("color",color);
            startActivity( intent );
            //Toast.makeText(this,"Gano el jugador 1",Toast.LENGTH_LONG).show();
            finish();
            desactivar_botones();
        }else if(flag2){
            Intent intent = new Intent( UnJugadorActivity.this , WinnerActivityJ1.class );
            intent.putExtra( "nombre" , nombrej2 );
            intent.putExtra("imgganador", aux==1?tacha:circulo );
            intent.putExtra("nombrej1" , nombrej1);
            intent.putExtra( "nombrej2",nombrej2);
            intent.putExtra("Select", aux);
            intent.putExtra("color",color);
            startActivity( intent );
            //Toast.makeText(this,"Gano el jugador 2",Toast.LENGTH_LONG).show();
            finish();
            desactivar_botones();

        }

    }






}