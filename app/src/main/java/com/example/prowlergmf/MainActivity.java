package com.example.prowlergmf;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_PERMISSION_INTERNET = 100;
    private static final int REQUEST_PERMISSION_WIFI = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void crear(View view){
        Intent creara = new Intent(view.getContext(),Crearcuenta.class);
        startActivity(creara);
    }
    public void iniciarsesion(View view){
        Intent sec = new Intent(view.getContext(),Inicarsesion.class);
        startActivity(sec);
    }
    public void apagar(View view){
       finishAffinity();
    }


}
