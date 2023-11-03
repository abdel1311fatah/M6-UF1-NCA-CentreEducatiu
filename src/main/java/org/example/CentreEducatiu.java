package org.example;

import org.example.Alumnes.Alumne;
import org.example.Empleats.Professor;
import org.example.Files.Notes;
import org.example.Menu.Menu;

import java.io.*;
import java.util.ArrayList;

public class CentreEducatiu {

    public CentreEducatiu() {
    }
    Menu menu = new Menu();
    public Notes mirarNotes() throws IOException, ClassNotFoundException {
        ArrayList<Alumne> alumnes = new ArrayList<>();
        menu = new Menu();
        File directoriAlumnes = new File(menu.ruta() + "alumnes.dat");
        int indexAlumneTrobat = 0;
        boolean trobat = false, acabat = false;

        try { // s omple l arraylist amb alumnes del fitxer d alumnes

            FileInputStream fis = new FileInputStream(directoriAlumnes); // part per a pillar els alumnes
            ObjectInputStream ois = new ObjectInputStream(fis);

            alumnes = (ArrayList<Alumne>) ois.readObject();

            ois.close();
            fis.close();
        } catch (EOFException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Introdueix el teu dni ");
        String nif = menu.nif();

        if (alumnes.size() >= 0) {
            for (int i = 0; i < alumnes.size(); i++) {
                if (nif.equalsIgnoreCase(alumnes.get(i).getDni()) && !trobat) {
                    trobat = true;
                    indexAlumneTrobat = i;
                }
            }
        } else {
            System.out.println("No hi han alumnes inscrits");
        }

        if (trobat) {
            Alumne alumneTrobat = alumnes.get(indexAlumneTrobat);
            ArrayList<Notes> notes = new ArrayList<>();
            File directoriNotes = new File(menu.ruta() + "notes.dat");

            try {
                FileInputStream fis = new FileInputStream(directoriNotes);
                ObjectInputStream ois = new ObjectInputStream(fis);

                notes = (ArrayList<Notes>) ois.readObject();

                ois.close();
                fis.close();
            } catch (EOFException e) {
                e.printStackTrace();
            }

            trobat = false;
            for (Notes nota : notes) {
                if (nota.getAlumne().getDni().equalsIgnoreCase(alumneTrobat.getDni()) && !trobat) {
                    trobat = true;
                    System.out.println("Les dades del alumne son:" + nota.getAlumne().toString() + " i te un " + nota.getNota() + " de nota");
                    return nota;

                }
            }

        } else {
            System.out.println("No s'ha trobat cap alumne");
        }

        return null;
    }
    public Professor mirarProfessor() throws IOException, ClassNotFoundException {
        ArrayList<Professor> professors = new ArrayList<>();
        File directoriProfessors = new File(menu.ruta() + "professors.dat");
        int indexProfessorTrobat = 0;
        boolean trobat = false, acabat = false;

        try {
            // Llena el ArrayList con profesores del archivo "professors.dat"
            FileInputStream fis = new FileInputStream(directoriProfessors);
            ObjectInputStream ois = new ObjectInputStream(fis);

            professors = (ArrayList<Professor>) ois.readObject();

            ois.close();
            fis.close();
        } catch (EOFException e) {
            e.printStackTrace();
        }

        System.out.println("DNI del profesor que vols trobar: ");
        String nif = menu.nif();

        if (professors.size() >= 0) {
            for (int i = 0; i < professors.size(); i++) {
                if (nif.equalsIgnoreCase(professors.get(i).getDni()) && !trobat) {
                    trobat = true;
                    indexProfessorTrobat = i;
                }
            }
        } else {
            System.out.println("No hi han professors inscrits");
        }

        if (trobat) {
            Professor professorTrobat = professors.get(indexProfessorTrobat);
            System.out.println("El professor de DNI " + nif + " te aquestes dades: " + professorTrobat.toString());
            return professorTrobat;
        } else {
            System.out.println("No s'ha trobat cap professor");
        }
        return null;
    }
    public Alumne mirarAlumne() throws IOException, ClassNotFoundException {
        ArrayList<Alumne> alumnes = new ArrayList<>();
        File directoriAlumnes = new File(menu.ruta() + "alumnes.dat");
        int indexAlumneTrobat = 0;
        boolean trobat = false, acabat = false;

        if(!directoriAlumnes.exists()){
            directoriAlumnes.createNewFile();
        }

        try { // s omple l arraylist amb alumnes del fitxer d alumnes

            FileInputStream fis = new FileInputStream(directoriAlumnes); // part per a pillar els alumnes
            ObjectInputStream ois = new ObjectInputStream(fis);

            alumnes = (ArrayList<Alumne>) ois.readObject();

            ois.close();
            fis.close();
        } catch (EOFException e) {
            e.printStackTrace();
        }

        System.out.println("DNI del alumne que vols trobar: ");
        String nif = menu.nif();

        if (alumnes.size() >= 0) {
            for (int i = 0; i < alumnes.size(); i++) {
                if (nif.equalsIgnoreCase(alumnes.get(i).getDni()) && !trobat) {
                    trobat = true;
                    indexAlumneTrobat = i;
                }
            }
        } else {
            System.out.println("No hi han alumnes inscrits");
        }

        if (trobat) {
            Alumne alumneTrobat = alumnes.get(indexAlumneTrobat);
            System.out.println("L'alumne de DNI " + nif + " te aquestes dades: " + alumneTrobat.toString());
            return alumneTrobat;
        } else {
            System.out.println("No s ha trobat cap alumne");
        }
        return null;
    }

}
