package com.example.leaa.listapropia;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.net.URL;


public class AdaptadorPropio extends ArrayAdapter<SoporteListaPropia> {
    Activity context;
    SoporteListaPropia[] datos;

    public AdaptadorPropio(Activity context, SoporteListaPropia[] datos){
        super(context, R.layout.activity_adaptador_propio, datos);
        this.context=context;
        this.datos = datos;
    }

    public AdaptadorPropio(){
        super(null, 0);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.activity_adaptador_propio, null);

        TextView lblRanking = (TextView)item.findViewById(R.id.ranking);
        lblRanking.setText("Rank: "+datos[position].getRank());

        TextView lblCountry = (TextView)item.findViewById(R.id.country);
        lblCountry.setText("Contry: " + datos[position].getCountry());

        TextView lblpopulation = (TextView)item.findViewById(R.id.population);
        lblpopulation.setText("population: " + datos[position].getPopulation());

        ImageView imgImagen = (ImageView)item.findViewById(R.id.flag);
        Picasso.with(context).load(datos[position].getImagen()).placeholder(R.drawable.loading).into(imgImagen);


        return(item);
    }





}
