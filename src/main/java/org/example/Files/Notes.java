package org.example.Files;

import org.example.Alumnes.Alumne;

public class Notes {

    private Alumne alumne;
    private String assignatura;
    private int nota;

    public Notes() {
    }
    public Notes(Alumne alumne, String assignatura, int nota) {
        this.alumne = alumne;
        this.assignatura = assignatura;
        this.nota = nota;
    }

    public Alumne getAlumne() {
        return alumne;
    }

    public void setAlumne(Alumne alumne) {
        this.alumne = alumne;
    }

    public String getAssignatura() {
        return assignatura;
    }

    public void setAssignatura(String assignatura) {
        this.assignatura = assignatura;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
}
