package com.aguitech.compartetuexperiencia;

import android.content.Intent;
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

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

}
