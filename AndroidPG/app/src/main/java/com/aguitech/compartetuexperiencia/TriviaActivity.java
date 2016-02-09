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
import org.json.JSONException;
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
                for(int i = 0; i < jsonArray.length(); i++){
                    JSONObject child = null;//get first child value
                    try {
                        child = jsonArray.getJSONObject(i);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    //TODO haz lo que necesites para cada iteración
                    triviaPregunta.setText(child.optString("pregunta"));
                    triviaRespuesta1.setText(child.optString("respuesta1"));
                    triviaRespuesta2.setText(child.optString("respuesta2"));
                    triviaRespuesta3.setText(child.optString("respuesta3"));
                    triviaRespuesta4.setText(child.optString("respuesta4"));

                    triviaRespuesta1.setOnClickListener(getButtonOnClickListener("param1","param2"));
                }
            }else{
                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
            }
        }
    }


    public View.OnClickListener getButtonOnClickListener(String param1, String param2){
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO Stuff with param1 and param2
            }
        };
    }

}
