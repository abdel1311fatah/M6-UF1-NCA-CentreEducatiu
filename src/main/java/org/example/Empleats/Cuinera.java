package org.example.Empleats;

import java.io.Serializable;

public class Cuinera extends Empleat implements Serializable {
    public Cuinera(String dni, String nom, String cognom, String email, int edat) {
        super(dni, nom, cognom, email, edat);
    }

}