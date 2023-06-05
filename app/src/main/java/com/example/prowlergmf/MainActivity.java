package com.example.prowlergmf;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void crear(View view){
        Intent registrar = new Intent(view.getContext(),Crearcuenta.class);
        startActivity(registrar);
    }
    public void iniciarsesion(View view){
        Intent registrar = new Intent(view.getContext(),Inicarsesion.class);
        startActivity(registrar);
    }
}