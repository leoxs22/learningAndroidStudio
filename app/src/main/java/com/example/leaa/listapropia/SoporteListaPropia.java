package com.example.leaa.listapropia;

/**
 * Created by leaa on 09/06/2015.
 */
public class SoporteListaPropia {
    private int rank;
    private String country;
    private String population;
    private String imagen;

    public SoporteListaPropia(int ranking,String count, String pop, String img){
        rank=ranking;
        country=count;
        population=pop;
        imagen=img;
    }

    public int getRank() {
        return rank;
    }

    public String getCountry() {
        return country;
    }

    public String getPopulation() {
        return population;
    }

    public String getImagen() {
        return imagen;
    }
}
