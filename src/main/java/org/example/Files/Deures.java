package org.example.Files;

import java.io.Serializable;
import java.util.Objects;

import org.example.Empleats.Professor;

public class Deures implements Serializable {

    private String assignatura;
    private Professor professor;

    public Deures() {
    }

    public Deures(String assignatura, Professor professor) {
        this.assignatura = assignatura;
        this.professor = professor;
    }

    public String getAssignatura() {
        return assignatura;
    }

    public void setAssignatura(String assignatura) {
        this.assignatura = assignatura;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Deures deures)) return false;
        return Objects.equals(getAssignatura(), deures.getAssignatura()) && Objects.equals(getProfessor(), deures.getProfessor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAssignatura(), getProfessor());
    }

    @Override
    public String toString() {
        return "Deures{" +
                "assignatura='" + assignatura + '\'' +
                ", professor=" + professor +
                '}';
    }
}
