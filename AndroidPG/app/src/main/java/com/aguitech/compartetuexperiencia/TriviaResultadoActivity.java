package com.aguitech.compartetuexperiencia;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

public class TriviaResultadoActivity extends AppCompatActivity {

    private ProgressDialog pDialog;
    private HashMap<String,String> data;
    //private String url = "http://emocionganar.com/admin/panel/webservice_blog_android.php";
    private String url = "http://emocionganar.com/admin/panel/webservice_resultado_trivia.php";

    public String getTriviaValue;
    public String getNombreValue = "";
    public String getIDValue = "";

    private TextView respuestasCorrectas;
    private TextView respuestasIncorrectas;
    private TextView totalPreguntas;
    private TextView resultadoEvento;
    private TextView resultadoPartipacion;
    private TextView resultadoEventoFecha;
    private TextView resultadoTiempo;
    private ImageButton resultadoTerminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trivia_resultado);

        respuestasCorrectas = (TextView) findViewById(R.id.triviaResultadoCorrectas);
        resultadoEvento = (TextView) findViewById(R.id.triviaResultadoEvento);
        resultadoPartipacion = (TextView) findViewById(R.id.triviaResultadoPartipacion);
        resultadoEventoFecha = (TextView) findViewById(R.id.triviaResultadoEventoFecha);
        resultadoTiempo = (TextView) findViewById(R.id.triviaResultadoTiempo);
        resultadoTerminar = (ImageButton) findViewById(R.id.triviaResultadoTerminar);

        /*
        respuestasCorrectas = (TextView) findViewById(R.id.triviaResultadoCorrectas);
        respuestasIncorrectas = (TextView) findViewById(R.id.triviaResultadoIncorrectas);
        totalPreguntas = (TextView) findViewById(R.id.triviaResultadoPreguntas);
*/
        resultadoTerminar.setOnClickListener(new View.OnClickListener(){
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
                i.setClass(TriviaResultadoActivity.this, MenuPrincipalActivity.class);
                startActivity(i);

            }
        });


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
            //String getNombreValue =(String) b.get("Nombre");
            getTriviaValue =(String) b.get("trivia");
            //Textv.setText(j);
            //Toast.makeText(getApplicationContext(), getTriviaValue, Toast.LENGTH_SHORT).show();
            //String getIDValue =(String) b.get("ID");

        }

        new connectPhp().execute();

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
            i.setClass(TriviaResultadoActivity.this, MenuPrincipalActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_blog) {
            Intent i = new Intent();
            i.putExtra("Nombre", getNombreValue);
            i.putExtra("ID", getIDValue);
            i.putExtra("Dios", "Mi nombre es Hector");
            i.setClass(TriviaResultadoActivity.this, BlogActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_eventos) {
            Intent i = new Intent();
            i.putExtra("Nombre", getNombreValue);
            i.putExtra("ID", getIDValue);
            i.putExtra("Dios", "Mi nombre es Hector");
            i.setClass(TriviaResultadoActivity.this, EventosActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_trivias) {
            Intent i = new Intent();
            i.putExtra("Nombre", getNombreValue);
            i.putExtra("ID", getIDValue);
            i.putExtra("Dios", "Mi nombre es Hector");
            i.setClass(TriviaResultadoActivity.this, TriviasActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_ganadores) {
            Intent i = new Intent();
            i.putExtra("Nombre", getNombreValue);
            i.putExtra("ID", getIDValue);
            i.putExtra("Dios", "Mi nombre es Hector");
            i.setClass(TriviaResultadoActivity.this, GanadoresActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_como_participar) {
            Intent i = new Intent();
            i.putExtra("Nombre", getNombreValue);
            i.putExtra("ID", getIDValue);
            i.putExtra("Dios", "Mi nombre es Hector");
            i.setClass(TriviaResultadoActivity.this, ComoParticiparActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_compartir_redes) {
            Intent i = new Intent();
            i.putExtra("Nombre", getNombreValue);
            i.putExtra("ID", getIDValue);
            i.putExtra("Dios", "Mi nombre es Hector");
            i.setClass(TriviaResultadoActivity.this, CompartirRedesActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_terminos_condiciones) {
            Intent i = new Intent();
            i.putExtra("Nombre", getNombreValue);
            i.putExtra("ID", getIDValue);
            i.putExtra("Dios", "Mi nombre es Hector");
            i.setClass(TriviaResultadoActivity.this, TerminosCondicionesActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_aviso_privacidad) {
            Intent i = new Intent();
            i.putExtra("Nombre", getNombreValue);
            i.putExtra("ID", getIDValue);
            i.putExtra("Dios", "Mi nombre es Hector");
            //i.setClass(EventosActivity.this, AvisoPrivacidadActivity.class);
            i.setClass(TriviaResultadoActivity.this, WebviewActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_contacto) {
            Intent i = new Intent();
            i.putExtra("Nombre", getNombreValue);
            i.putExtra("ID", getIDValue);
            i.putExtra("Dios", "Mi nombre es Hector");
            i.setClass(TriviaResultadoActivity.this, ContactoActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_salir) {
            Intent i = new Intent();
            i.putExtra("Nombre", getNombreValue);
            i.putExtra("ID", getIDValue);
            i.putExtra("Dios", "Mi nombre es Hector");
            i.setClass(TriviaResultadoActivity.this, MenuPrincipalActivity.class);
            startActivity(i);

            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }
    public class connectPhp extends AsyncTask<String, String, String> {

        //String getEdittextValue = name.getText().toString();

        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            pDialog = new ProgressDialog(TriviaResultadoActivity.this);
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

            SharedPreferences mispreferencias = getSharedPreferences("PreferenciasUsuario", Context.MODE_PRIVATE);
            String IDUsuario = mispreferencias.getString("ID", "");
            String NombreUsuario = mispreferencias.getString("Nombre", "");


            //data.put("valores", getTriviaValue);
            //data.put("id", getIDValue);
            data.put("valores", getTriviaValue);
            //data.put("id", "1000");
            data.put("id", IDUsuario);



            //Toast.makeText(getApplicationContext(), "checa", Toast.LENGTH_SHORT).show();
            //Toast.makeText(getApplicationContext(), getIDEvento, Toast.LENGTH_SHORT).show();


            try{

                //JSONObject json = jsonParser.makeHttpRequest(url, "POST", args);//to pass url, method, and args
                //now connect using JSONParsr class
                JSONObject json = HttpUrlConnectionParser.makehttpUrlConnection(url,data);

                /**
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //result.setText(getValue.toString());
                        Toast.makeText(getApplicationContext(), "Funciona XD", Toast.LENGTH_SHORT).show();
                        //result.setText(getValue.toString());
                        respuestasCorrectas.setText("adasdkmkn");
                        respuestasIncorrectas.setText("asadasda");
                        totalPreguntas.setText("njnjnjnj");

                    }
                });
                */

                int succ = json.getInt("success");//get response from server
                if(succ == 0){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                        }
                    });
                }else{
                    JSONArray jsonArray = json.getJSONArray("resultado");//get parent node

                    JSONObject child = jsonArray.getJSONObject(0);//get first child value


                    final String respuestasCorrectasValue = child.optString("respuestas_correctas");
                    //final String respuestasIncorrectasValue = child.optString("respuestas_incorrectas");
                    //final String totalPreguntasValue = child.optString("total_preguntas");
                    final String fechaHoraValue = child.optString("fecha_creacion") + " " + child.optString("hora_creacion");

                    final String premioValue = child.optString("premio");
                    final String eventoValue = child.optString("evento");


                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //result.setText(getValue.toString());
                            //Toast.makeText(getApplicationContext(), "Funciona XD", Toast.LENGTH_SHORT).show();
                            //result.setText(getValue.toString());
                            //Toast.makeText(getApplicationContext(), "Work XD", Toast.LENGTH_SHORT).show();

                            respuestasCorrectas.setText(respuestasCorrectasValue.toString());
                            resultadoEventoFecha.setText(fechaHoraValue.toString());


                            //resultadoEvento.setText("Nuevo Evento");
                            resultadoEvento.setText(eventoValue.toString());

                            //resultadoPartipacion.setText("Participacion");
                            //resultadoTiempo.setText("60 segundos");
                            resultadoPartipacion.setText(premioValue.toString());
                            //resultadoTiempo.setText("60 segundos");
                            /*
                            //resultadoEventoFecha

                            respuestasCorrectas.setText(respuestasCorrectasValue.toString());
                            respuestasIncorrectas.setText(respuestasIncorrectasValue.toString());
                            totalPreguntas.setText(totalPreguntasValue.toString());
                            */





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

}
