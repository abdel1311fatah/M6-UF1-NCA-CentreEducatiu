package org.example.Files;

import java.io.Serializable;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Horari horari)) return false;
        return getHora() == horari.getHora() && Objects.equals(getAssignatura(), horari.getAssignatura());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHora(), getAssignatura());
    }
}
