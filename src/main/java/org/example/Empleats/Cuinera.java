package org.example.Empleats;

import java.io.Serializable;

public class Cuinera extends Empleat implements Serializable {
    // Puedes agregar atributos específicos de Cuinera si es necesario

    public Cuinera(String dni, String nom, String cognom, int edat) {
        super(dni, nom, cognom, edat);
    }
}