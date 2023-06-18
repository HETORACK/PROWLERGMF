package com.example.prowlergmf;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
public class slash extends AppCompatActivity {

ImageView imgvprowlera, imgvgm,imgvprowleraa;
AnimationDrawable anima = new AnimationDrawable();
int tiempo = 50;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_slash);

        Animation anima1= AnimationUtils.loadAnimation(this,R.anim.desplazamiento_arriba);
        Animation anima2= AnimationUtils.loadAnimation(this,R.anim.desplazamiento_abajo);


        imgvprowlera = findViewById(R.id.imgvprowlera);
        imgvgm=findViewById(R.id.imgvgm);
        imgvprowleraa=findViewById(R.id.imgvprowleraa);
        imgvprowleraa.setVisibility(View.GONE);


        imgvgm.setAnimation(anima2);
        imgvprowlera.setAnimation(anima1);




        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                imgvprowleraa.setVisibility(View.VISIBLE);
                imgvprowlera.setVisibility(View.GONE);
                Parpadear();
                anima.start();


            }
        },2000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                anima.stop();
                Intent inicia = new Intent(slash.this, MainActivity.class);
                startActivity(inicia);
            }
        },5000);
    }
    public void Parpadear(){
        anima.addFrame(getResources().getDrawable(R.drawable.a1),tiempo);
        anima.addFrame(getResources().getDrawable(R.drawable.a2),tiempo);
        anima.addFrame(getResources().getDrawable(R.drawable.a3),tiempo);
        anima.addFrame(getResources().getDrawable(R.drawable.a4),tiempo);
        anima.addFrame(getResources().getDrawable(R.drawable.a5),tiempo);
        anima.addFrame(getResources().getDrawable(R.drawable.a6),tiempo);
        anima.addFrame(getResources().getDrawable(R.drawable.a7),tiempo);
        anima.addFrame(getResources().getDrawable(R.drawable.a8),tiempo);
        anima.addFrame(getResources().getDrawable(R.drawable.a9),tiempo);
        anima.addFrame(getResources().getDrawable(R.drawable.a10),tiempo);
        anima.addFrame(getResources().getDrawable(R.drawable.a11),tiempo);
        anima.addFrame(getResources().getDrawable(R.drawable.a12),tiempo);
        anima.addFrame(getResources().getDrawable(R.drawable.a13),tiempo);
        anima.addFrame(getResources().getDrawable(R.drawable.a14),tiempo);
        anima.addFrame(getResources().getDrawable(R.drawable.a15),tiempo);
        anima.addFrame(getResources().getDrawable(R.drawable.a16),tiempo);
        anima.addFrame(getResources().getDrawable(R.drawable.a17),250);
        anima.addFrame(getResources().getDrawable(R.drawable.a17),tiempo);
        anima.addFrame(getResources().getDrawable(R.drawable.a16),tiempo);
        anima.addFrame(getResources().getDrawable(R.drawable.a15),tiempo);
        anima.addFrame(getResources().getDrawable(R.drawable.a14),tiempo);
        anima.addFrame(getResources().getDrawable(R.drawable.a13),tiempo);
        anima.addFrame(getResources().getDrawable(R.drawable.a12),tiempo);
        anima.addFrame(getResources().getDrawable(R.drawable.a11),tiempo);
        anima.addFrame(getResources().getDrawable(R.drawable.a10),tiempo);
        anima.addFrame(getResources().getDrawable(R.drawable.a9),tiempo);
        anima.addFrame(getResources().getDrawable(R.drawable.a8),tiempo);
        anima.addFrame(getResources().getDrawable(R.drawable.a7),tiempo);
        anima.addFrame(getResources().getDrawable(R.drawable.a6),tiempo);
        anima.addFrame(getResources().getDrawable(R.drawable.a5),tiempo);
        anima.addFrame(getResources().getDrawable(R.drawable.a4),tiempo);
        anima.addFrame(getResources().getDrawable(R.drawable.a3),tiempo);
        anima.addFrame(getResources().getDrawable(R.drawable.a2),tiempo);
        anima.addFrame(getResources().getDrawable(R.drawable.a1),tiempo);
        anima.addFrame(getResources().getDrawable(R.drawable.a1),1000);
        imgvprowleraa.setBackgroundDrawable(anima);

    }

}