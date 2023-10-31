package org.example.Empleats;

import java.io.Serializable;

public class Secretaria extends Empleat implements Serializable {

    public Secretaria(String dni, String nom, String cognom, String email, int edat) {
        super(dni, nom, cognom, email, edat);
    }
}
