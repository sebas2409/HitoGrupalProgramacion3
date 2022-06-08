package com.example.hitogrupalprogramacion3.models;

public class User {

    public static String globalUser;
    private String nombre;

    public User(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
