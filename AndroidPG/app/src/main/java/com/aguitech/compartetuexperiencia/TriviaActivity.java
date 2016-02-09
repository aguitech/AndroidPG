package com.aguitech.compartetuexperiencia;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

public class TriviaActivity extends AppCompatActivity {

    private TextView triviaPregunta;
    private Button triviaRespuesta1;
    private Button triviaRespuesta2;
    private Button triviaRespuesta3;
    private Button triviaRespuesta4;

    private ProgressDialog pDialog;
    private HashMap<String,String> data;
    //private String url = "http://emocionganar.com/admin/panel/webservice_blog_android.php";
    private String url = "http://emocionganar.com/admin/panel/webservice_trivia.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trivia);

        triviaPregunta = (TextView) findViewById(R.id.triviaPregunta);
        triviaRespuesta1 = (Button) findViewById(R.id.triviaRespuesta1);
        triviaRespuesta2 = (Button) findViewById(R.id.triviaRespuesta2);
        triviaRespuesta3 = (Button) findViewById(R.id.triviaRespuesta3);
        triviaRespuesta4 = (Button) findViewById(R.id.triviaRespuesta4);

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
    public class connectPhp extends AsyncTask<String, String, String> {

        //String getEdittextValue = name.getText().toString();

        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            pDialog = new ProgressDialog(TriviaActivity.this);
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
            data.put("id", "0");


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
                    JSONArray jsonArray = json.getJSONArray("trivia");//get parent node

                    JSONObject child = jsonArray.getJSONObject(0);//get first child value
                    final String triviaPreguntaValue = child.optString("pregunta");
                    final String triviaRespuesta1Value = child.optString("respuesta1");
                    final String triviaRespuesta2Value = child.optString("respuesta2");
                    final String triviaRespuesta3Value = child.optString("respuesta3");
                    final String triviaRespuesta4Value = child.optString("respuesta4");






                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //result.setText(getValue.toString());
                            Toast.makeText(getApplicationContext(), "Funciona XD", Toast.LENGTH_SHORT).show();
                            //result.setText(getValue.toString());
                            triviaPregunta.setText(triviaPreguntaValue.toString());

                            triviaRespuesta1.setText(triviaRespuesta1Value.toString());
                            triviaRespuesta2.setText(triviaRespuesta2Value.toString());
                            triviaRespuesta3.setText(triviaRespuesta3Value.toString());
                            triviaRespuesta4.setText(triviaRespuesta4Value.toString());


                            //blogNombreImagen1.setText(blogImagen2value.toString());

                            //String ImageUrl2 = "http://enobra.com.mx/images/Imagen2.jpg";

                            //new ImageLoaderClass().execute(ImageUrl);



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
