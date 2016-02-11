package com.aguitech.compartetuexperiencia;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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
    private TextView triviaContador;

    public String getNombreValue = "";
    public String getIDValue = "";

    private ProgressDialog pDialog;
    private HashMap<String,String> data;
    //private String url = "http://emocionganar.com/admin/panel/webservice_blog_android.php";
    private String url = "http://emocionganar.com/admin/panel/webservice_trivia.php";
    private FragmentManager fragmentManager;

    private TextView triviaContador2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trivia);

        triviaContador2 = (TextView) findViewById(R.id.triviaContador2);

        fragmentManager = getSupportFragmentManager();


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
            //String getNombreValue =(String) b.get("Nombre");

            //String getIDValue =(String) b.get("ID");

        }

        new connectPhp().execute();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        new CountDownTimer(10000, 1000) {

            public void onTick(long millisUntilFinished) {
                triviaContador2.setText("seconds remaining: " + millisUntilFinished / 1000);
                //here you can have your logic to set text to edittext
            }

            public void onFinish() {
                triviaContador2.setText("done!");
                Intent i = new Intent();
                i.putExtra("trivia", TriviaFragment.arrayRespuestas);
                i.putExtra("Nombre", getNombreValue);
                i.putExtra("ID", getIDValue);

                //i.putExtra("ID", getIDValue);
                //i.setClass(MainActivity.this, PantallaActivity.class);
                //i.setClass(MainActivity.this, RegistroActivity.class);
                i.setClass(TriviaActivity.this, TriviaResultadoActivity.class);
                startActivity(i);
            }

        }.start();




    }
    public class connectPhp extends AsyncTask<String, String, JSONArray> {
        JSONArray jsonArray;

        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            pDialog = new ProgressDialog(TriviaActivity.this);
            pDialog.setIndeterminate(false);
            pDialog.setMessage("Connecting...");
            pDialog.show();
        }

        @Override
        protected JSONArray doInBackground(String... params){
            //List <NameValuePair> args = new ArrayList<NameValuePair>();
            //args.add(new BasicNameValuePair("name", getEdittextValue));//this is key and value to post data
            data = new HashMap<String, String>();
            //data.put("name", getEdittextValue);
            //data.put("id", "0");
            data.put("id", "0");

            try{
                //JSONObject json = jsonParser.makeHttpRequest(url, "POST", args);//to pass url, method, and args
                //now connect using JSONParsr class
                JSONObject json = HttpUrlConnectionParser.makehttpUrlConnection(url,data);
                int succ = json.getInt("success");//get response from server
                if(succ == 0){
                    return null;
                }else{
                    jsonArray = json.getJSONArray("trivia");//get parent node
                    return jsonArray;
                }
            }catch(Exception e){
                return null;
            }
        }

        @Override
        protected void onPostExecute(JSONArray jsonArray){
            super.onPostExecute(jsonArray);
            pDialog.cancel();

            if(jsonArray != null){
                try {
                    Fragment fragment = new TriviaFragment(jsonArray.getJSONObject(0), jsonArray.length(), 0, jsonArray, "");
                    fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else{
                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
            }
        }
    }

}
