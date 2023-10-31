package org.example.Empleats;

import java.io.File;
import java.io.Serializable;

public class Professor extends Empleat implements Serializable {
    private File assignatures;
    private String curs;
    public Professor(String dni, String nom, String cognom, int edat, File assignatures, String curs) {
        super(dni, nom, cognom, edat);
        this.assignatures = assignatures;
        this.curs = curs;
    }

    public File getAssignatures() {
        return assignatures;
    }

    public void setAssignatures(File assignatures) {
        this.assignatures = assignatures;
    }

    public String getCurs() {
        return curs;
    }

    public void setCurs(String curs) {
        this.curs = curs;
    }
}
