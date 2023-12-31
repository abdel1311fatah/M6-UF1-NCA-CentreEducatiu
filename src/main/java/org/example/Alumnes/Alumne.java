package org.example.Alumnes;

import java.io.File;
import java.io.Serializable;
import java.util.Objects;

public class Alumne implements Serializable {
    private String dni;
    private String nom;
    private String cognom;
    private String curs;
    private int edat;

    public Alumne() {
    }

    public Alumne(String dni, String nom, String cognom, String curs, int edat) {
        this.dni = dni;
        this.nom = nom;
        this.cognom = cognom;
        this.curs = curs;
        this.edat = edat;
    }
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public String getCurs() {
        return curs;
    }

    public void setCurs(String curs) {
        this.curs = curs;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    @Override
    public String toString() {
        return "Alumne{" +
                "dni='" + dni + '\'' +
                ", nom='" + nom + '\'' +
                ", cognom='" + cognom + '\'' +
                ", curs='" + curs + '\'' +
                ", edat=" + edat +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Alumne alumne)) return false;
        return getEdat() == alumne.getEdat() && Objects.equals(getDni(), alumne.getDni()) && Objects.equals(getNom(), alumne.getNom()) && Objects.equals(getCognom(), alumne.getCognom()) && Objects.equals(getCurs(), alumne.getCurs());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDni(), getNom(), getCognom(), getCurs(), getEdat());
    }
}
