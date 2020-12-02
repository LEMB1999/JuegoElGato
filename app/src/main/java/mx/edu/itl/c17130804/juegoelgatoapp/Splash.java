package mx.edu.itl.c17130804.juegoelgatoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        //Agregar Animacion
        Animation animation_logo = AnimationUtils.loadAnimation(this,R.anim.desplazamiento_arriba);
        Animation animation_text = AnimationUtils.loadAnimation(this,R.anim.desplazamiento_abajo);

        TextView text = findViewById(R.id.Texto);
        ImageView imgView = findViewById(R.id.Logo);

        //Asignar Animaciones
        text.setAnimation(animation_text);
        imgView.setAnimation(animation_logo);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this,Menu.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }
}

