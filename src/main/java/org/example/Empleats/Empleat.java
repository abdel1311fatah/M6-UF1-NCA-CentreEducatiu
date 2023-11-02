package org.example.Empleats;

import java.io.Serializable;

public class Empleat implements Serializable{
    private String dni;
    private String nom;
    private String cognom;
    private String email;
    private int edat;

    public Empleat() {
    }

    public Empleat(String dni, String nom, String cognom, String email, int edat) {
        this.dni = dni;
        this.nom = nom;
        this.cognom = cognom;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    @Override
    public String toString() {
        return "Empleat{" +
                "dni='" + dni + '\'' +
                ", nom='" + nom + '\'' +
                ", cognom='" + cognom + '\'' +
                ", email='" + email + '\'' +
                ", edat=" + edat +
                '}';
    }
}
