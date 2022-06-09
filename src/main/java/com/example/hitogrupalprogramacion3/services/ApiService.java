package com.example.hitogrupalprogramacion3.services;

import com.example.hitogrupalprogramacion3.models.Campos;
import com.example.hitogrupalprogramacion3.models.Votation;
import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;

import java.util.ArrayList;

public class ApiService {

    public static ArrayList<Integer> listaVulne;
    public static  ArrayList<Integer> listaRendi;
    public static ArrayList<Integer> listaCE;
    public static ArrayList<Integer> listaEst;
    public static ArrayList<Integer> listaFunci;
    private final Gson gson = new Gson();

    public void getVotes() throws UnirestException {
        HttpResponse<JsonNode> apiResponse = Unirest.get("endpoint").asJson();
        JSONArray json = apiResponse.getBody().getArray();


        listaVulne = new ArrayList<>();
        listaRendi = new ArrayList<>();
        listaCE = new ArrayList<>();
        listaEst = new ArrayList<>();
        listaFunci = new ArrayList<>();

        for (int i = 0; i < json.length(); i++) {
            Campos campos = gson.fromJson(json.get(i).toString(),Campos.class);
            listaCE.add(campos.getControlErrores());
            listaEst.add(campos.getEstetica());
            listaRendi.add(campos.getRendimiento());
            listaFunci.add(campos.getFuncionalidad());
            listaVulne.add(campos.getVulnerabilidad());
        }

    }

    public void sendVote(Votation votation) throws UnirestException {
        String voting = gson.toJson(votation);
        System.out.println(voting);
        Unirest.post("endpoint").body(voting).asJson();
    }

    public static String getMedia(ArrayList<Integer> lista){
        int media = 0;
        for (int i:lista){
            media +=i;
        }
        return Integer.toString(media/lista.size());
    }


}
