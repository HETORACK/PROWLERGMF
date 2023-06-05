package com.example.prowlergmf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class iniciarseg extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciarseg);
    }
    public void regresar(View view){
        Intent registrar = new Intent(view.getContext(),Crearcuenta.class);
        startActivity(registrar);
    }
    public void inicio(View view){
        Intent registrar = new Intent(view.getContext(),MainActivity.class);
        startActivity(registrar);
    }
}