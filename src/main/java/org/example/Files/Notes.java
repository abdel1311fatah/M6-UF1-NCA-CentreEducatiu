package org.example.Files;

import org.example.Alumnes.Alumne;

import java.io.Serializable;

public class Notes implements Serializable {

    private Alumne alumne;
    private String curs;

    public Notes() {
    }

    public Notes(Alumne alumne, String curs) {
        this.alumne = alumne;
        this.curs = curs;
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
}
