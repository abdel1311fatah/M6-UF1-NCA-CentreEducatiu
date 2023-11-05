package org.example.Files;

import org.example.Alumnes.Alumne;

import java.io.Serializable;
import java.util.Objects;

public class Notes implements Serializable {

    private Alumne alumne;
    private String curs;
    private int nota;

    public Notes() {
    }

    public Notes(Alumne alumne, String curs, int nota) {
        this.alumne = alumne;
        this.curs = curs;
        this.nota = nota;
    }

    public Alumne getAlumne() {
        return alumne;
    }

    public void setAlumne(Alumne alumne) {
        this.alumne = alumne;
    }

    public String getCurs() {
        return curs;
    }

    public void setCurs(String curs) {
        this.curs = curs;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Notes{" +
                "alumne=" + alumne.toString() +
                ", curs='" + curs + '\'' +
                ", nota=" + nota +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Notes notes)) return false;
        return getNota() == notes.getNota() && Objects.equals(getAlumne(), notes.getAlumne()) && Objects.equals(getCurs(), notes.getCurs());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAlumne(), getCurs(), getNota());
    }
}
