package com.example.prowlergmf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Recuperar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar);
    }
    public void regresar(View view){
        Intent registrar = new Intent(view.getContext(),Inicarsesion.class);
        startActivity(registrar);

    }
    public void sig(View view){
        Intent registrar = new Intent(view.getContext(),Saludo.class);
        startActivity(registrar);
    }
}