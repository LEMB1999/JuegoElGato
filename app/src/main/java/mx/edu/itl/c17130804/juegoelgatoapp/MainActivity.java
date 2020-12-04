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


public class MainActivity extends AppCompatActivity {


    TextView text;
    String nombrej1 = "Jugador 1" , nombrej2 = "Jugador 2";
    ArrayList<ImageView> arr ;
    int  ids[];
    ArrayList<Integer>  arr_valores ;
    int turno = 0;
    int  num_turnos = 0;
    int coordenadas [][] = { {0,1,2},{0,3,6},{2,5,8},{6,7,8},{0,4,8},{2,4,6},{1,4,7},{3,4,5}};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //inicializar atributos
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

        arr.add(findViewById(ids[0]));
        arr.add(findViewById(ids[1]));
        arr.add(findViewById(ids[2]));
        arr.add(findViewById(ids[3]));
        arr.add(findViewById(ids[4]));
        arr.add(findViewById(ids[5]));
        arr.add(findViewById(ids[6]));
        arr.add(findViewById(ids[7]));
        arr.add(findViewById(ids[8]));

        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        turno = b.getInt( "select");
        nombrej1 = b.getString("nombre1" );
        nombrej2 = b.getString( "nombre2" );
        if(nombrej1.isEmpty())
            nombrej1 = "Jugador 1";
        if(nombrej2.isEmpty())
            nombrej2 = "Jugador 2";
        if(turno == 0)
            text.setText( nombrej1 );
        if(turno == 1)
            text.setText( nombrej2 );
    }



    public void  cambiar_imagen(int id, int turno){
        ImageView img = findViewById(id);
        if( turno == 0){
            Glide.with(this).load(R.drawable.tacha).into(img);
        }else{
            Glide.with(this).load(R.drawable.circulo).into(img);
        }
    }


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
          if (num_turnos>=4){
              flag1 = verificar_ganador(0);
              flag2 = verificar_ganador(1);
          }else{
              num_turnos++;
          }
          //desactivar boton
          view.setEnabled(false);

          if(flag1){
              Toast.makeText(this,"Gano el jugador 1",Toast.LENGTH_LONG).show();
              desactivar_botones();
          }else if(flag2){
              Toast.makeText(this,"Gano el jugador 2",Toast.LENGTH_LONG).show();
              desactivar_botones();
          }

    }

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

    public void desactivar_botones(){
            for( int i = 0; i<arr.size();i++){
                arr.get(i).setEnabled(false);
            }
    }




}