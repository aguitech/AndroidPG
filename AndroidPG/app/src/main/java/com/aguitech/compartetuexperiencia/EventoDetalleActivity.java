package com.aguitech.compartetuexperiencia;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;

public class EventoDetalleActivity extends AppCompatActivity {

    public String getNombreValue = "";
    public String getIDValue = "";
    public String getIDEvento = "";

    private TextView eventoDetalleTitulo;
    private TextView eventoDetalleFecha;
    private TextView eventoDetalleResenia;
    private TextView eventoDetalleDescripcion;
    private ImageView eventoDetalleImagen;
    Bitmap Imagebitmap;

    private ProgressDialog pDialog;
    private HashMap<String,String> data;
    //private String url = "http://emocionganar.com/admin/panel/webservice_blog_android.php";
    private String url = "http://emocionganar.com/admin/panel/webservice_evento_android_detalle.php";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento_detalle);

        eventoDetalleTitulo = (TextView) findViewById(R.id.eventoDetalleTitulo);
        eventoDetalleFecha = (TextView) findViewById(R.id.eventoDetalleFecha);
        eventoDetalleResenia = (TextView) findViewById(R.id.eventoDetalleResenia);
        eventoDetalleDescripcion = (TextView) findViewById(R.id.eventoDetalleDescripcion);
        eventoDetalleImagen = (ImageView) findViewById(R.id.eventoDetalleImagen);



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
            //String getIDValue =(String) b.get("ID");
            getIDEvento =(String) b.get("IDEvento");

            Toast.makeText(getApplicationContext(), getIDEvento, Toast.LENGTH_SHORT).show();
        }

        new connectPhp().execute();

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
            i.setClass(EventoDetalleActivity.this, MenuPrincipalActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_blog) {
            Intent i = new Intent();
            i.putExtra("Nombre", getNombreValue);
            i.putExtra("ID", getIDValue);
            i.putExtra("Dios", "Mi nombre es Hector");
            i.setClass(EventoDetalleActivity.this, BlogActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_trivias) {
            Intent i = new Intent();
            i.putExtra("Nombre", getNombreValue);
            i.putExtra("ID", getIDValue);
            i.putExtra("Dios", "Mi nombre es Hector");
            i.setClass(EventoDetalleActivity.this, TriviasActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_terminos_condiciones) {
            Intent i = new Intent();
            i.putExtra("Nombre", getNombreValue);
            i.putExtra("ID", getIDValue);
            i.putExtra("Dios", "Mi nombre es Hector");
            i.setClass(EventoDetalleActivity.this, TerminosCondicionesActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_aviso_privacidad) {
            Intent i = new Intent();
            i.putExtra("Nombre", getNombreValue);
            i.putExtra("ID", getIDValue);
            i.putExtra("Dios", "Mi nombre es Hector");
            //i.setClass(EventosActivity.this, AvisoPrivacidadActivity.class);
            i.setClass(EventoDetalleActivity.this, WebviewActivity.class);
            startActivity(i);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }
    public class connectPhp extends AsyncTask<String, String, String> {

        //String getEdittextValue = name.getText().toString();

        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            pDialog = new ProgressDialog(EventoDetalleActivity.this);
            pDialog.setIndeterminate(false);
            pDialog.setMessage("Connecting...");
            pDialog.show();
        }

        @Override
        protected String doInBackground(String... params){
            //List <NameValuePair> args = new ArrayList<NameValuePair>();
            //args.add(new BasicNameValuePair("name", getEdittextValue));//this is key and value to post data
            data = new HashMap<String, String>();
            //data.put("name", getEdittextValue);
            //data.put("id", "0");
            data.put("id", getIDEvento);
            //Toast.makeText(getApplicationContext(), "checa", Toast.LENGTH_SHORT).show();
            //Toast.makeText(getApplicationContext(), getIDEvento, Toast.LENGTH_SHORT).show();


            try{

                //JSONObject json = jsonParser.makeHttpRequest(url, "POST", args);//to pass url, method, and args
                //now connect using JSONParsr class
                JSONObject json = HttpUrlConnectionParser.makehttpUrlConnection(url,data);
                int succ = json.getInt("success");//get response from server
                if(succ == 0){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                        }
                    });
                }else{
                    JSONArray jsonArray = json.getJSONArray("evento");//get parent node

                    JSONObject child = jsonArray.getJSONObject(0);//get first child value
                    final String eventoTituloValue = child.optString("nombre");
                    final String eventoFechaValue = child.optString("fecha");
                    final String eventoReseniaValue = child.optString("evento");
                    final String eventoDescripcionValue = child.optString("descripcion");
                    final String eventoImagenValue = child.optString("imagen");






                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //result.setText(getValue.toString());
                            Toast.makeText(getApplicationContext(), "Funciona XD", Toast.LENGTH_SHORT).show();
                            //result.setText(getValue.toString());
                            eventoDetalleTitulo.setText(eventoTituloValue.toString());
                            eventoDetalleFecha.setText(eventoFechaValue.toString());
                            eventoDetalleResenia.setText(eventoReseniaValue.toString());
                            eventoDetalleDescripcion.setText(eventoDescripcionValue.toString());

                            //blogNombreImagen1.setText(blogImagen2value.toString());

                            //String ImageUrl2 = "http://enobra.com.mx/images/Imagen2.jpg";
                            String ImageUrlEvento = eventoImagenValue.toString();
                            //new ImageLoaderClass().execute(ImageUrl);

                            /*
                            new ImageLoaderClass().execute(ImageUrl1);
                            */

                            //new ImageLoaderClass().execute(ImageUrl);


                            //String ImageUrl2 = blogImagen2value.toString();
                            //new ImageLoaderClass2().execute(ImageUrl2);

                            //estudiante1.setNombre("María");

                            //SetImageViewHolder2 = (ImageView) findViewById(R.id.blogImagen1);

                            //new ImageLoaderClass3().execute(ImageUrl3);

                            ImageLoaderClass nuevaImagen2 = new ImageLoaderClass();
                            nuevaImagen2.SetImageViewHolder3(eventoDetalleImagen);
                            nuevaImagen2.SetImagebitmap3(Imagebitmap);
                            nuevaImagen2.execute(ImageUrlEvento);






                            //String ImageUrl2 = blogImagen2value.toString();
                            /*
                            Intent i = new Intent();
                            i.putExtra("Nombre", "Mi nombre es Hector");
                            //i.setClass(MainActivity.this, PantallaActivity.class);
                            //i.setClass(MainActivity.this, RegistroActivity.class);
                            i.setClass(BlogActivity.this, RegistroActivity.class);
                            startActivity(i);
                            */
                        }
                    });
                }
            }catch(Exception e){

            }



            return null;
        }

        @Override
        protected void onPostExecute(String a){
            super.onPostExecute(a);
            pDialog.cancel();
        }
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

}