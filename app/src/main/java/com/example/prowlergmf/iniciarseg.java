package com.example.prowlergmf;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class iniciarseg extends AppCompatActivity {
TextView txttexto;
EditText txterespreg;
ImageView imgvsonido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciarseg);
        txttexto=findViewById(R.id.txttexto);
        imgvsonido=findViewById(R.id.imgvsonido);
        txterespreg= findViewById(R.id.txteresppreg);
        imgvsonido.setVisibility(View.VISIBLE);
    }
    private static final int RECOGNIZE_SPEECH_ACTIVITY = 1;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case RECOGNIZE_SPEECH_ACTIVITY:
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> speech = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    String strSpeech2Text = speech.get(0);
                    txttexto.setText(strSpeech2Text);
                }
                break;
            default:
                break;
        }
    }
    public void Hablar(View view){
        imgvsonido.setVisibility(View.GONE);
        Intent intentActionRecognizeSpeech = new Intent(
                RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intentActionRecognizeSpeech.putExtra(
                RecognizerIntent.EXTRA_LANGUAGE_MODEL, "es-MX");
        try {
            startActivityForResult(intentActionRecognizeSpeech,
                    RECOGNIZE_SPEECH_ACTIVITY);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(), "Tú dispositivo no soporta el reconocimiento por voz", Toast.LENGTH_SHORT).show();
        }
    }
    public void limpiar(View view){
        txttexto.setText("");
        txterespreg.setText("");

    }
    public boolean Validar(){
       boolean retorno=true;
       if(txttexto.getText().toString().trim().length()==0 || txterespreg.getText().toString().trim().length()==0){
           retorno=false;
       }
        return retorno;
    }
    public void regresar(View view){
        Intent registrar = new Intent(view.getContext(),Crearcuenta.class);
        startActivity(registrar);
    }
    public void inicio(View view) {
        if (Validar()) {
            Intent registrar = new Intent(view.getContext(), MainActivity.class);
            startActivity(registrar);
            Toast.makeText(this, "Ahora sí", Toast.LENGTH_LONG).show();
        }
    else{
            Toast.makeText(this, "Debes tener un plan b por si olvidas la contraseña", Toast.LENGTH_LONG).show();
    }
}
}