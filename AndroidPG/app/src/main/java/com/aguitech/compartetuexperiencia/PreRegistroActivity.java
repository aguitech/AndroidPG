package com.aguitech.compartetuexperiencia;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

public class PreRegistroActivity extends AppCompatActivity {

    private ImageButton btnComenzarApp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_registro);

        btnComenzarApp = (ImageButton) findViewById(R.id.btnComenzarApp);

        btnComenzarApp.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                Intent i = new Intent();
                i.putExtra("Nombre", "Mi nombre es Hector");
                //i.setClass(MainActivity.this, PantallaActivity.class);
                //i.setClass(MainActivity.this, RegistroActivity.class);
                i.setClass(PreRegistroActivity.this, RegistroActivity.class);
                startActivity(i);

            }
        });

        CargarPreferencias();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    public void CargarPreferencias(){
        //SharedPreferences mispreferencias = getSharedPreferences("PreferenciasUsuario", Context.NODE_PRIVATE);
        SharedPreferences mispreferencias = getSharedPreferences("PreferenciasUsuario", Context.MODE_PRIVATE);
        //txtnombre.setText(mispreferencias.getString(“nombre”, “”));
        //Toast.makeText(getApplicationContext(), "Cargando Preferencias", Toast.LENGTH_SHORT).show();
        //Toast.makeText(getApplicationContext(), mispreferencias.getString("Nombre", ""), Toast.LENGTH_SHORT).show();
        //Toast.makeText(getApplicationContext(), mispreferencias.getString("ID", ""), Toast.LENGTH_SHORT).show();
        String IDUsuario = mispreferencias.getString("ID", "");
        //Toast.makeText(getApplicationContext(), "Cargando Preferencias Iniciales", Toast.LENGTH_SHORT).show();
        //Toast.makeText(getApplicationContext(), IDUsuario, Toast.LENGTH_SHORT).show();

        if(IDUsuario != ""){
            //Toast.makeText(getApplicationContext(), "Tenemos sesion activa", Toast.LENGTH_SHORT).show();

            Intent i = new Intent();
            i.putExtra("Nombre", "Mi nombre es Hector");
            //i.setClass(MainActivity.this, PantallaActivity.class);
            //i.setClass(MainActivity.this, RegistroActivity.class);
            //i.setClass(PreRegistroActivity.this, RegistroActivity.class);
            i.setClass(PreRegistroActivity.this, MenuPrincipalActivity.class);
            startActivity(i);

        }

    }

}
