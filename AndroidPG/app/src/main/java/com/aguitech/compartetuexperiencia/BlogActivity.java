package com.aguitech.compartetuexperiencia;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class BlogActivity extends AppCompatActivity implements Download_data_blog.download_complete {

    public ListView list_blog;
    public ArrayList<Countries> countries = new ArrayList<Countries>();
    public ListAdapterBlog adapterBlog;

    public String getNombreValue = "";
    public String getIDValue = "";

    public ImageButton btnBlogTrivias;
    public ImageButton btnBlogCalendario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);

        btnBlogTrivias = (ImageButton) findViewById(R.id.btnBlogTrivias);
        btnBlogCalendario = (ImageButton) findViewById(R.id.btnBlogCalendario);

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

        btnBlogTrivias.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                //new connectPhp().execute();
                //new connectPhp().execute();
                Intent i = new Intent();
                i.putExtra("Nombre", getNombreValue);
                i.putExtra("ID", getIDValue);
                i.putExtra("Dios", "Mi nombre es Hector");
                //i.setClass(MainActivity.this, PantallaActivity.class);
                //i.setClass(MainActivity.this, RegistroActivity.class);
                i.setClass(BlogActivity.this, TriviasActivity.class);
                startActivity(i);

            }
        });

        btnBlogCalendario.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                //new connectPhp().execute();
                //new connectPhp().execute();
                Intent i = new Intent();
                i.putExtra("Nombre", getNombreValue);
                i.putExtra("ID", getIDValue);
                i.putExtra("Dios", "Mi nombre es Hector");
                //i.setClass(MainActivity.this, PantallaActivity.class);
                //i.setClass(MainActivity.this, RegistroActivity.class);
                i.setClass(BlogActivity.this, EventosActivity.class);
                startActivity(i);

            }
        });

        list_blog = (ListView) findViewById(R.id.list_blog);
        adapterBlog = new ListAdapterBlog(this);
        list_blog.setAdapter(adapterBlog);

        list_blog.setOnItemClickListener(new AdapterView.OnItemClickListener() {

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
                i.putExtra("IDBlog", valor_posicion);
                i.setClass(BlogActivity.this, BlogDetalleActivity.class);
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

        Download_data_blog download_data = new Download_data_blog((Download_data_blog.download_complete) this);
        //download_data.download_data_from_link("http://www.kaleidosblog.com/tutorial/tutorial.json");
        //download_data.download_data_from_link("https://emocionganar.com/admin/panel/webservice_evento_android.php");
        download_data.download_data_from_link("https://emocionganar.com/admin/panel/webservice_blog_android_nuevo.php");


        //new ImageLoaderClass().execute(ImageUrl);

        /*
        connect.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                new connectPhp().execute();

            }
        });
        */

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */
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
            i.setClass(BlogActivity.this, MenuPrincipalActivity.class);
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
            i.setClass(BlogActivity.this, EventosActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_trivias) {
            Intent i = new Intent();
            i.putExtra("Nombre", getNombreValue);
            i.putExtra("ID", getIDValue);
            i.putExtra("Dios", "Mi nombre es Hector");
            i.setClass(BlogActivity.this, TriviasActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_ganadores) {
            Intent i = new Intent();
            i.putExtra("Nombre", getNombreValue);
            i.putExtra("ID", getIDValue);
            i.putExtra("Dios", "Mi nombre es Hector");
            i.setClass(BlogActivity.this, GanadoresActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_como_participar) {
            Intent i = new Intent();
            i.putExtra("Nombre", getNombreValue);
            i.putExtra("ID", getIDValue);
            i.putExtra("Dios", "Mi nombre es Hector");
            i.setClass(BlogActivity.this, ComoParticiparActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_compartir_redes) {
            Intent i = new Intent();
            i.putExtra("Nombre", getNombreValue);
            i.putExtra("ID", getIDValue);
            i.putExtra("Dios", "Mi nombre es Hector");
            i.setClass(BlogActivity.this, CompartirRedesActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_terminos_condiciones) {
            Intent i = new Intent();
            i.putExtra("Nombre", getNombreValue);
            i.putExtra("ID", getIDValue);
            i.putExtra("Dios", "Mi nombre es Hector");
            i.setClass(BlogActivity.this, TerminosCondicionesActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_aviso_privacidad) {
            Intent i = new Intent();
            i.putExtra("Nombre", getNombreValue);
            i.putExtra("ID", getIDValue);
            i.putExtra("Dios", "Mi nombre es Hector");
            i.setClass(BlogActivity.this, AvisoPrivacidadActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_contacto) {
            Intent i = new Intent();
            i.putExtra("Nombre", getNombreValue);
            i.putExtra("ID", getIDValue);
            i.putExtra("Dios", "Mi nombre es Hector");
            i.setClass(BlogActivity.this, ContactoActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_salir) {



            Intent i = new Intent();
            i.putExtra("Nombre", getNombreValue);
            i.putExtra("ID", getIDValue);
            i.putExtra("Dios", "Mi nombre es Hector");
            i.setClass(BlogActivity.this, MenuPrincipalActivity.class);
            startActivity(i);

            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);

            //Toast.makeText(getApplicationContext(), "SALIR XD", Toast.LENGTH_SHORT).show();

            //finish();

            //System.exit(0);

            //Intent intent = new Intent(Intent.ACTION_MAIN);
            //finish();

            /*
            int p = android.os.Process.myPid();
            android.os.Process.killProcess(p);

            Intent i = new Intent();
            i.putExtra("Nombre", getNombreValue);
            i.putExtra("ID", getIDValue);
            i.putExtra("Dios", "Mi nombre es Hector");
            i.setClass(BlogActivity.this, MenuPrincipalActivity.class);
            startActivity(i);

            */

            return true;

        }


        return super.onOptionsItemSelected(item);
    }

    public class ImageLoaderClass extends AsyncTask<String, String, Bitmap> {

        private ImageView SetImageViewHolder;
        private Bitmap Imagebitmap;

        public void SetImageViewHolder3(ImageView setImageViewHolder) {
            this.SetImageViewHolder = setImageViewHolder;
        }
        public void SetImagebitmap3(Bitmap imagebitmap) {
            this.Imagebitmap = imagebitmap;
        }
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }
        protected Bitmap doInBackground(String... args) {
            try {
                Imagebitmap = BitmapFactory.decodeStream((InputStream)new URL(args[0]).getContent());

            } catch (Exception e) {
                e.printStackTrace();
            }
            return Imagebitmap;
        }

        protected void onPostExecute(Bitmap image) {

            if(image != null){
                SetImageViewHolder.setImageBitmap(image);

            }
        }



    }
    public void get_data(String data)
    {

        try {
            JSONArray data_array=new JSONArray(data);

            for (int i = 0 ; i < data_array.length() ; i++)
            {
                JSONObject obj=new JSONObject(data_array.get(i).toString());

                Countries add=new Countries();
                add.name = obj.getString("titulo");
                //add.code = obj.getString("blog");

                countries.add(add);

            }

            adapterBlog.notifyDataSetChanged();

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

}
