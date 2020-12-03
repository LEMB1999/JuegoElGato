package mx.edu.itl.c17130804.juegoelgatoapp;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    ArrayList<ImageView> arr ;
    int turno = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arr = new ArrayList<>(9);

        arr.add(findViewById(R.id.img1));
        arr.add(findViewById(R.id.img2));
        arr.add(findViewById(R.id.img3));
        arr.add(findViewById(R.id.img4));
        arr.add(findViewById(R.id.img5));
        arr.add(findViewById(R.id.img6));
        arr.add(findViewById(R.id.img7));
        arr.add(findViewById(R.id.img8));
        arr.add(findViewById(R.id.img9));

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
          turno = turno == 0?1:0;
          cambiar_imagen(view.getId(),turno);
    }






}