package com.example.leaa.listapropia;

import android.os.Debug;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Queue;


public class ListaPropia extends ActionBarActivity {
    private static final String TAG = ListaPropia.class.getSimpleName();
    SoporteListaPropia[] datos= new SoporteListaPropia[]{};
    ProgressBar progress;
    ListView lstOpciones;
    RequestQueue queue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_propia);
        lstOpciones = (ListView)findViewById(R.id.lista);
        progress = (ProgressBar)findViewById(R.id.progressBar);

        setearPaises("http://www.androidbegin.com/tutorial/jsonparsetutorial.txt");
        AdaptadorPropio adaptador = new AdaptadorPropio(this,datos);


        lstOpciones.setAdapter(adaptador);
        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {

            }
        });
    }

    private void setearPaises(String url){
        Log.d(TAG, "entre a setear paises");
        queue=Volley.newRequestQueue(this);
        Log.d(TAG, "La segui a setear paises");
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.d(TAG, "recibi respuesta");
                armarListaDesdeString(response);
                Log.d(TAG, "termine armar lista");
            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.d(TAG,"me morfe un error");
                volleyError.printStackTrace();
            }
        });
        queue.add(jsonArrayRequest);
        Log.d(TAG,"Agregue a queue");
    }

    private void armarListaDesdeString(JSONArray array){
        Log.d(TAG, "Estoy armando lista");
        for(int i=0;i<array.length();i++){
            try {
                JSONObject jso = (JSONObject) array.get(i);
                SoporteListaPropia item = new SoporteListaPropia(jso.getInt("rank"),jso.getString("country"), jso.getString("population"),jso.getString("flag"));
                datos[i]=item;

            }catch(JSONException e){
                e.printStackTrace();
            }
        }
        progress.setVisibility(View.INVISIBLE);
        lstOpciones.setVisibility(View.VISIBLE);

    }








}
