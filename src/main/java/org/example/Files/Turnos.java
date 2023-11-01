package org.example.Files;

import org.example.Empleats.Empleat;
import org.example.Empleats.Professor;
import org.example.Empleats.Secretaria;

import java.io.Serializable;
import java.sql.Timestamp;

public class Turnos implements Serializable {
    private String dni;
    private Timestamp data;

    public Turnos() {
    }
    public Turnos(String nif, Timestamp data) {
        this.dni = dni;
        this.data = data;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Turnos{" +
                "dni='" + dni + '\'' +
                ", data=" + data +
                '}';
    }
}
