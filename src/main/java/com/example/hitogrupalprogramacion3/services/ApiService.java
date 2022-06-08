package com.example.hitogrupalprogramacion3.services;

import com.example.hitogrupalprogramacion3.models.User;
import com.example.hitogrupalprogramacion3.models.Votation;
import com.google.gson.Gson;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class ApiService {

    private final Gson gson = new Gson();

//    public void get(){
//        HttpResponse<JsonNode> apiResponse = Unirest.get("http://localhost:8080/").asJson();
//        String responseJsonAsString = apiResponse.getBody().toString();
//        System.out.println(responseJsonAsString);
//    }

    public void sendVote(Votation votation) throws UnirestException {
        String voting = gson.toJson(votation);
        System.out.println(voting);
        Unirest.post("http://localhost:8080/adduser").body(voting).asJson();


    }


}
