package org.example.Empleats;

import org.example.Empleats.Empleat;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

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
                "} " + super.toString();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Professor professor)) return false;
        if (!super.equals(o)) return false;
        return Arrays.equals(getAssignatures(), professor.getAssignatures()) && Objects.equals(getCurs(), professor.getCurs());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(super.hashCode(), getCurs());
        result = 31 * result + Arrays.hashCode(getAssignatures());
        return result;
    }
}
