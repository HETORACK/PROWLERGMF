package com.example.prowlergmf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Inicarsesion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicarsesion);
    }
    public void ingresar(View view){
        Intent registrar = new Intent(view.getContext(),Inicarsesion.class);
        startActivity(registrar);
    }public void olvidar(View view){
        Intent registrar = new Intent(view.getContext(),Recuperar.class);
        startActivity(registrar);
    }
}