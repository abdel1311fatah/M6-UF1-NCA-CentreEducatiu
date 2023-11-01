package org.example.Empleats;

import java.io.File;
import java.io.Serializable;
import java.util.Arrays;

public class Professor extends Empleat implements Serializable {
    private String[] assignatures;
    private String curs;

    public Professor() {
    }

    public Professor(String dni, String nom, String cognom, String email, int edat, String[] assignatures, String curs) {
        super(dni, nom, cognom, email, edat);
        this.assignatures = assignatures;
        this.curs = curs;
    }

    public String[] getAssignatures() {
        return assignatures;
    }

    public void setAssignatures(String[] assignatures) {
        this.assignatures = assignatures;
    }

    public String getCurs() {
        return curs;
    }

    public void setCurs(String curs) {
        this.curs = curs;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "assignatures=" + Arrays.toString(assignatures) +
                ", curs='" + curs + '\'' +
                '}';
    }
}
