package com.example.hitogrupalprogramacion3.models;

public class Votation {

    private User user;
    private int estetica;
    private int vulnerabilidad;
    private int funcionalidad;
    private int controlErrores;
    private int rendimiento;

    public Votation(User user, int estetica, int vulnerabilidad, int funcionalidad, int controlErrores, int rendimiento) {
        this.user = user;
        this.estetica = estetica;
        this.vulnerabilidad = vulnerabilidad;
        this.funcionalidad = funcionalidad;
        this.controlErrores = controlErrores;
        this.rendimiento = rendimiento;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getEstetica() {
        return estetica;
    }

    public void setEstetica(int estetica) {
        this.estetica = estetica;
    }

    public int getVulnerabilidad() {
        return vulnerabilidad;
    }

    public void setVulnerabilidad(int vulnerabilidad) {
        this.vulnerabilidad = vulnerabilidad;
    }

    public int getFuncionalidad() {
        return funcionalidad;
    }

    public void setFuncionalidad(int funcionalidad) {
        this.funcionalidad = funcionalidad;
    }

    public int getControlErrores() {
        return controlErrores;
    }

    public void setControlErrores(int controlErrores) {
        this.controlErrores = controlErrores;
    }

    public int getRendimiento() {
        return rendimiento;
    }

    public void setRendimiento(int rendimiento) {
        this.rendimiento = rendimiento;
    }
}
