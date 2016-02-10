package com.aguitech.compartetuexperiencia;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by it on 09/02/16.
 */
public class TriviaFragment extends Fragment {
    private View view;
    private JSONObject jsonObject;
    private JSONArray jsonArray;
    private int length, i;
    private TextView triviaPregunta;
    private Button triviaRespuesta1;
    private Button triviaRespuesta2;
    private Button triviaRespuesta3;
    private Button triviaRespuesta4;
    private FragmentManager fragmentManager;
    public static String arrayRespuestas;
    private TextView triviaContador;

    public TriviaFragment(JSONObject jsonObject, int length, int i, JSONArray jsonArray, String arrayRespuestas){
        this.jsonObject = jsonObject;
        this.length = length;
        this.i = i;
        this.jsonArray = jsonArray;
        this.arrayRespuestas = arrayRespuestas;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.content_trivia, container, false);

        triviaPregunta = (TextView) view.findViewById(R.id.triviaPregunta);
        triviaRespuesta1 = (Button) view.findViewById(R.id.triviaRespuesta1);
        triviaRespuesta2 = (Button) view.findViewById(R.id.triviaRespuesta2);
        triviaRespuesta3 = (Button) view.findViewById(R.id.triviaRespuesta3);
        triviaRespuesta4 = (Button) view.findViewById(R.id.triviaRespuesta4);
        triviaContador = (TextView) view.findViewById(R.id.triviaContador);

        triviaPregunta.setText(jsonObject.optString("pregunta"));
        triviaRespuesta1.setText(jsonObject.optString("respuesta1"));
        triviaRespuesta2.setText(jsonObject.optString("respuesta2"));
        triviaRespuesta3.setText(jsonObject.optString("respuesta3"));
        triviaRespuesta4.setText(jsonObject.optString("respuesta4"));



        //triviaContador.setText(String.valueOf(R.id.content_frame));
        triviaContador.setText(arrayRespuestas);


        fragmentManager = getFragmentManager();

        try {
            triviaRespuesta1.setOnClickListener(getButtonOnClickListener(jsonObject.getString("id_pregunta"),jsonObject.getString("id_respuesta1")));
            triviaRespuesta2.setOnClickListener(getButtonOnClickListener(jsonObject.getString("id_pregunta"),jsonObject.getString("id_respuesta2")));
            triviaRespuesta3.setOnClickListener(getButtonOnClickListener(jsonObject.getString("id_pregunta"),jsonObject.getString("id_respuesta3")));
            triviaRespuesta4.setOnClickListener(getButtonOnClickListener(jsonObject.getString("id_pregunta"),jsonObject.getString("id_respuesta4")));

        }catch (Exception e){
            e.printStackTrace();
        }



        return view;
    }

    public View.OnClickListener getButtonOnClickListener(final String id_pregunta, final String id_respuestaN){
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO Stuff with param1 and param2
                try {
                    if(i < length-1){
                        Fragment fragment = new TriviaFragment(jsonArray.getJSONObject(i+1), jsonArray.length(), i+1, jsonArray, arrayRespuestas+id_pregunta+","+id_respuestaN+";");
                        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
                    }else{
                        //TODO Start new activity
                        Log.i("RESPUESTAS","-->"+arrayRespuestas+id_pregunta+","+id_respuestaN+";");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }
}
