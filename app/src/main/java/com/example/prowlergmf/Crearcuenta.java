package com.example.prowlergmf;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Crearcuenta extends AppCompatActivity {

    EditText txteusu, txtepasword, txteconfpas, txtenom, txteneg, txtetel, txtedirec, txtemincue, txteprocue, txteproque,txteaquien;
    RadioGroup rdbgtipo;
    RadioButton rdbmino, rdbprove;
    Spinner spnclamin;
    CheckBox cbxpape, cbxaba, cbxout,cbxcal, cbxali, cbxtlapa,cbxespe;
    LinearLayout llvprove,llvmino;
    int tipo=0,tipoentre,t1=0,t2=0,t3=0,t4=0,t5=0,t6=0,t7=0,seleccion,espe;
    String tipominu;
    RequestQueue requestQueue;
    private static final String URL1 = "http://201.102.30.200/android/cliente.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crearcuenta);

        requestQueue = Volley.newRequestQueue(this);

        txteusu=findViewById(R.id.txteusu);
        txtepasword=findViewById(R.id.txtepasword);
        txteconfpas=findViewById(R.id.txteconfpas);
        txtenom=findViewById(R.id.txtenom);
        txteneg=findViewById(R.id.txteneg);
        txtetel=findViewById(R.id.txtetel);
        txtedirec=findViewById(R.id.txtedirec);
        txtemincue=findViewById(R.id.txtemincue);
        txteprocue=findViewById(R.id.txteprocue);
        rdbgtipo=findViewById(R.id.rdbgtipo);
        rdbmino=findViewById(R.id.rdbmino);
        rdbprove=findViewById(R.id.rdbprove);
        spnclamin=findViewById(R.id.spnclamin);
        cbxpape=findViewById(R.id.cbxpape);
        cbxaba=findViewById(R.id.cbxaba);
        cbxout=findViewById(R.id.cbxout);
        cbxcal=findViewById(R.id.cbxcal);
        cbxali=findViewById(R.id.cbxali);
        cbxtlapa=findViewById(R.id.cbxtlapa);
        cbxespe=findViewById(R.id.cbxespe);
        llvmino=findViewById(R.id.llvmino);
        txteproque=findViewById(R.id.txteproque);
        llvprove=findViewById(R.id.llvprove);
        txteaquien=findViewById(R.id.txteaquien);
        ArrayAdapter Spin = ArrayAdapter.createFromResource(this,R.array.spnminoque, R.layout.spin_style);
        spnclamin.setAdapter(Spin);


        llvmino.setVisibility(View.GONE);
        llvprove.setVisibility(View.GONE);
        txteprocue.setVisibility(View.GONE);
        txtemincue.setVisibility(View.GONE);
        tipoentre=visibilidad();
        abastece();
        Spiner();

    }
    public void regresar(View view) {

            Intent registrar = new Intent(view.getContext(), MainActivity.class);
            startActivity(registrar);
        }

    public void sig(View view) {
        if (cbxespe.isChecked() && txteprocue.getText().toString().trim().length() == 0) {
            Toast.makeText(Crearcuenta.this, "Hablame de él", Toast.LENGTH_LONG).show();
            txteprocue.setVisibility(View.VISIBLE);
            txteprocue.requestFocus();

        } else {
            if (validar()==true){
                String nom = txtenom.getText().toString();
                String usu = txteusu.getText().toString();
                String cont = txtepasword.getText().toString();
                String ubi = txtedirec.getText().toString();
                String tel = txtetel.getText().toString();
                crearCli(nom,usu,cont,ubi,tel);

            }
            }

    }

    private void crearCli(final String nom, final String usu, final String cont, final String ubi, final String tel) {
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                URL1,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(Crearcuenta.this,"¡NUEVO USER!", Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("usu",usu);
                params.put("nom",nom);
                params.put("cont",cont);
                params.put("ubi",ubi);
                params.put("tel",tel);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    public boolean validar() {
        boolean retorno=true;
        if (txteusu.getText().toString().trim().length() == 0 || txtepasword.getText().toString().trim().length() == 0 || txteconfpas.getText().toString().trim().length() == 0 || txtenom.getText().toString().trim().length() == 0 || txteneg.getText().toString().trim().length() == 0 || txtetel.getText().toString().trim().length() == 0 || txtedirec.getText().toString().trim().length() == 0) {
            Toast.makeText(Crearcuenta.this, "No deje campos vacíos", Toast.LENGTH_LONG).show();
            retorno=false;
        }return retorno;
    }
    public int visibilidad(){
                rdbgtipo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rdbmino:  llvmino.setVisibility(View.VISIBLE);
                        llvprove.setVisibility(View.GONE);
                            txteaquien.requestFocus();
                             tipo=1;
                        break;
                    case R.id.rdbprove: llvmino.setVisibility(View.GONE);
                        llvprove.setVisibility(View.VISIBLE);
                        txteproque.requestFocus();
                        tipo=2;
                        break;
                }
            }
        });
        return tipo;
    }
    public void abastece(){
        if (cbxpape.isChecked()==true){
            t1=1;
        }
        if (cbxcal.isChecked()==true){
            t2=1;
        }
        if (cbxali.isChecked()==true){
            t3=1;
        }
        if (cbxaba.isChecked()==true){
            t4=1;
        }
        if (cbxout.isChecked()==true){
            t5=1;
        }
        if (cbxtlapa.isChecked()==true){
            t6=1;
        }
        if (cbxespe.isChecked()==true){
            t7=1;
        }
    }


    public String Spiner(){
        spnclamin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0: seleccion=0;
                        break;
                    case 1: seleccion=1;
                            tipominu="Papeleria";
                            Toast.makeText(Crearcuenta.this,"Su negocio es una Papeleria",Toast.LENGTH_LONG).show();
                        break;
                    case 2: seleccion=1;
                            tipominu="Abarrotes";
                        Toast.makeText(Crearcuenta.this,"Su negocio es Abarrotes",Toast.LENGTH_LONG).show();
                        break;
                    case 3: seleccion=1;
                        tipominu="Tlapaleria";
                        Toast.makeText(Crearcuenta.this,"Su negocio es una Tlapaleria",Toast.LENGTH_LONG).show();
                        break;
                    case 4: seleccion=1;
                        tipominu="Alimentos";
                        Toast.makeText(Crearcuenta.this,"Su negocio vende Alimentos",Toast.LENGTH_LONG).show();
                        break;
                    case 5: seleccion=1;
                        tipominu="Panadería";
                        Toast.makeText(Crearcuenta.this,"Su negocio es una Panadería",Toast.LENGTH_LONG).show();
                        break;
                    case 6: seleccion=1;
                        tipominu="Verduleria";
                        Toast.makeText(Crearcuenta.this,"Su negocio es una Verduleria",Toast.LENGTH_LONG).show();
                        break;
                    case 7: seleccion=1;
                        tipominu="Carnicería";
                        Toast.makeText(Crearcuenta.this,"Su negocio es una Carnicería",Toast.LENGTH_LONG).show();
                        break;
                    case 8: seleccion=1;
                        Toast.makeText(Crearcuenta.this,"Su negocio es una Especializado",Toast.LENGTH_LONG).show();
                        txtemincue.setVisibility(View.VISIBLE);
                        tipominu=txtemincue.getText().toString();
                        break;



                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        return tipominu;
    }

}