package com.aguitech.compartetuexperiencia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class TriviasActivity extends AppCompatActivity {

    public String getNombreValue = "";
    public String getIDValue = "";
    private ImageButton btnTrivias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trivias);


        btnTrivias = (ImageButton) findViewById(R.id.btnTrivias);

        /**
        View.OnClickListener getOnClickDoSomething(final Button btnTrivias)  {
            return new View.OnClickListener() {
                public void onClick(View v) {
                    btnTrivias.setText("text now set.. ");
                }
            };
        }

        btnTrivias.setOnClickListener(getOnClickDoSomething(btnTrivias));
        */

        Intent iin= getIntent();
        Bundle b = iin.getExtras();
        if(b!=null)
        {
            //String getNombreValue =(String) b.get("Nombre");
            getNombreValue =(String) b.get("Nombre");
            //Textv.setText(j);
            //Toast.makeText(getApplicationContext(), getNombreValue, Toast.LENGTH_SHORT).show();
            //String getIDValue =(String) b.get("ID");
            getIDValue =(String) b.get("ID");

            //Toast.makeText(getApplicationContext(), getIDValue, Toast.LENGTH_SHORT).show();
        }

        btnTrivias.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                Intent i = new Intent();
                i.putExtra("Nombre", getNombreValue);
                i.putExtra("ID", getIDValue);
                //i.setClass(MainActivity.this, PantallaActivity.class);
                //i.setClass(MainActivity.this, RegistroActivity.class);
                i.setClass(TriviasActivity.this, TriviaActivity.class);
                startActivity(i);

            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_home) {
            Intent i = new Intent();
            i.putExtra("Nombre", getNombreValue);
            i.putExtra("ID", getIDValue);
            i.putExtra("Dios", "Mi nombre es Hector");
            //i.setClass(MainActivity.this, PantallaActivity.class);
            //i.setClass(MainActivity.this, RegistroActivity.class);
            i.setClass(TriviasActivity.this, MenuPrincipalActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_blog) {
            Intent i = new Intent();
            i.putExtra("Nombre", getNombreValue);
            i.putExtra("ID", getIDValue);
            i.putExtra("Dios", "Mi nombre es Hector");
            //i.setClass(MainActivity.this, PantallaActivity.class);
            //i.setClass(MainActivity.this, RegistroActivity.class);
            i.setClass(TriviasActivity.this, BlogActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_eventos) {
            Intent i = new Intent();
            i.putExtra("Nombre", getNombreValue);
            i.putExtra("ID", getIDValue);
            i.putExtra("Dios", "Mi nombre es Hector");
            //i.setClass(MainActivity.this, PantallaActivity.class);
            //i.setClass(MainActivity.this, RegistroActivity.class);
            i.setClass(TriviasActivity.this, EventosActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_ganadores) {
            Intent i = new Intent();
            i.putExtra("Nombre", getNombreValue);
            i.putExtra("ID", getIDValue);
            i.putExtra("Dios", "Mi nombre es Hector");
            i.setClass(TriviasActivity.this, GanadoresActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_como_participar) {
            Intent i = new Intent();
            i.putExtra("Nombre", getNombreValue);
            i.putExtra("ID", getIDValue);
            i.putExtra("Dios", "Mi nombre es Hector");
            i.setClass(TriviasActivity.this, ComoParticiparActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_compartir_redes) {
            Intent i = new Intent();
            i.putExtra("Nombre", getNombreValue);
            i.putExtra("ID", getIDValue);
            i.putExtra("Dios", "Mi nombre es Hector");
            i.setClass(TriviasActivity.this, CompartirRedesActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_terminos_condiciones) {
            Intent i = new Intent();
            i.putExtra("Nombre", getNombreValue);
            i.putExtra("ID", getIDValue);
            i.putExtra("Dios", "Mi nombre es Hector");
            i.setClass(TriviasActivity.this, TerminosCondicionesActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_aviso_privacidad) {
            Intent i = new Intent();
            i.putExtra("Nombre", getNombreValue);
            i.putExtra("ID", getIDValue);
            i.putExtra("Dios", "Mi nombre es Hector");
            i.setClass(TriviasActivity.this, AvisoPrivacidadActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_contacto) {
            Intent i = new Intent();
            i.putExtra("Nombre", getNombreValue);
            i.putExtra("ID", getIDValue);
            i.putExtra("Dios", "Mi nombre es Hector");
            i.setClass(TriviasActivity.this, ContactoActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_salir) {
            Intent i = new Intent();
            i.putExtra("Nombre", getNombreValue);
            i.putExtra("ID", getIDValue);
            i.putExtra("Dios", "Mi nombre es Hector");
            i.setClass(TriviasActivity.this, MenuPrincipalActivity.class);
            startActivity(i);

            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
