package org.example.Files;

import java.io.Serializable;

public class Horari implements Serializable {

    private int hora;
    private String assignatura;

    public Horari(){

    }
    public Horari(int hora, String assignatura) {
        this.hora = hora;
        this.assignatura = assignatura;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public String getAssignatura() {
        return assignatura;
    }

    public void setAssignatura(String assignatura) {
        this.assignatura = assignatura;
    }
}
