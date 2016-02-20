package com.aguitech.compartetuexperiencia;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

//import com.aguitech.compartetuexperiencia.Download_data.download_complete;



public class EventosActivity extends AppCompatActivity implements Download_data.download_complete {



    public ListView list;
    public ArrayList<Countries> countries = new ArrayList<Countries>();
    public ListAdapter adapter;

    public String getNombreValue = "";
    public String getIDValue = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos);

        Intent iin= getIntent();
        Bundle b = iin.getExtras();
        if(b!=null)
        {
            //String getNombreValue =(String) b.get("Nombre");
            getNombreValue =(String) b.get("Nombre");
            //Textv.setText(j);
            Toast.makeText(getApplicationContext(), getNombreValue, Toast.LENGTH_SHORT).show();
            //String getIDValue =(String) b.get("ID");
            getIDValue =(String) b.get("ID");

            Toast.makeText(getApplicationContext(), getIDValue, Toast.LENGTH_SHORT).show();
        }

        list = (ListView) findViewById(R.id.list);
        adapter = new ListAdapter(this);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            //public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //String position_val =  position.toString();
                //Toast.makeText(getApplicationContext(), position_val, Toast.LENGTH_SHORT).show();
                //int yourtag1 = Log.d("Yourtag", position);
                String valor_posicion = String.valueOf(position);
                /*
                Toast.makeText(getApplicationContext(), "algun valor", Toast.LENGTH_SHORT).show();
                HashMap<String, Object> obj_nuevo = (HashMap<String, Object>) adapter.getItem(position);
                String name = (String) obj_nuevo.get("name");
                Log.d("Yourtag", name);
                Log.d("Position", adapter.getItem(position).toString());
                */
                //Toast.makeText(getApplicationContext(), , Toast.LENGTH_SHORT).show();
                Log.d("ROWSELECT", "" + id);
                Log.d("ROWSELECT2", "" + position);

                Intent i = new Intent();
                i.putExtra("Nombre", getNombreValue);
                i.putExtra("ID", getIDValue);
                i.putExtra("Dios", "Mi nombre es Hector");
                i.putExtra("IDEvento", valor_posicion);
                i.setClass(EventosActivity.this, EventoDetalleActivity.class);
                startActivity(i);
                /**
                 HashMap<String, Object> obj = (HashMap<String, Object>) adapter.getItem(position);
                 String name = (String) obj.get("name");
                 Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT).show();
                 *
                 *
                Object obj = list.getAdapter().getItem(position);
                String valueID = obj.toString();

                Toast.makeText(getApplicationContext(), valueID, Toast.LENGTH_SHORT).show();
                */
                //Log.d("MyLog", "Value is: "+value);
                //String name = // how code to get name value.
            }


        });

        Download_data download_data = new Download_data((Download_data.download_complete) this);
        //download_data.download_data_from_link("http://www.kaleidosblog.com/tutorial/tutorial.json");
        download_data.download_data_from_link("https://emocionganar.com/admin/panel/webservice_evento_android.php");




        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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
            i.setClass(EventosActivity.this, MenuPrincipalActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_blog) {
            Intent i = new Intent();
            i.putExtra("Nombre", getNombreValue);
            i.putExtra("ID", getIDValue);
            i.putExtra("Dios", "Mi nombre es Hector");
            i.setClass(EventosActivity.this, BlogActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_trivias) {
            Intent i = new Intent();
            i.putExtra("Nombre", getNombreValue);
            i.putExtra("ID", getIDValue);
            i.putExtra("Dios", "Mi nombre es Hector");
            i.setClass(EventosActivity.this, TriviasActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_ganadores) {
            Intent i = new Intent();
            i.putExtra("Nombre", getNombreValue);
            i.putExtra("ID", getIDValue);
            i.putExtra("Dios", "Mi nombre es Hector");
            i.setClass(EventosActivity.this, GanadoresActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_como_participar) {
            Intent i = new Intent();
            i.putExtra("Nombre", getNombreValue);
            i.putExtra("ID", getIDValue);
            i.putExtra("Dios", "Mi nombre es Hector");
            i.setClass(EventosActivity.this, ComoParticiparActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_compartir_redes) {
            Intent i = new Intent();
            i.putExtra("Nombre", getNombreValue);
            i.putExtra("ID", getIDValue);
            i.putExtra("Dios", "Mi nombre es Hector");
            i.setClass(EventosActivity.this, CompartirRedesActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_terminos_condiciones) {
            Intent i = new Intent();
            i.putExtra("Nombre", getNombreValue);
            i.putExtra("ID", getIDValue);
            i.putExtra("Dios", "Mi nombre es Hector");
            i.setClass(EventosActivity.this, TerminosCondicionesActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_aviso_privacidad) {
            Intent i = new Intent();
            i.putExtra("Nombre", getNombreValue);
            i.putExtra("ID", getIDValue);
            i.putExtra("Dios", "Mi nombre es Hector");
            //i.setClass(EventosActivity.this, AvisoPrivacidadActivity.class);
            i.setClass(EventosActivity.this, WebviewActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_contacto) {
            Intent i = new Intent();
            i.putExtra("Nombre", getNombreValue);
            i.putExtra("ID", getIDValue);
            i.putExtra("Dios", "Mi nombre es Hector");
            i.setClass(EventosActivity.this, ContactoActivity.class);
            startActivity(i);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }
    public void get_data(String data)
    {

        try {
            JSONArray data_array=new JSONArray(data);

            for (int i = 0 ; i < data_array.length() ; i++)
            {
                JSONObject obj=new JSONObject(data_array.get(i).toString());

                Countries add=new Countries();
                add.name = obj.getString("nombre");
                add.code = obj.getString("fecha");

                countries.add(add);

            }

            adapter.notifyDataSetChanged();

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }



}
