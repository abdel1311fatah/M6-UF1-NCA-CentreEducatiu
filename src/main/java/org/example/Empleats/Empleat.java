package org.example.Empleats;

import java.io.Serializable;

public class Empleat {
    private String dni;
    private String nom;
    private String cognom;
    private int edat;

    public Empleat(String dni, String nom, String cognom, int edat) {
        this.dni = dni;
        this.nom = nom;
        this.cognom = cognom;
        this.edat = edat;
    }

}
