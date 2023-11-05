package org.example.Files;

import org.example.Empleats.Empleat;
import org.example.Empleats.Professor;
import org.example.Empleats.Secretaria;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Turnos turnos)) return false;
        return Objects.equals(getDni(), turnos.getDni()) && Objects.equals(getData(), turnos.getData());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDni(), getData());
    }
}
