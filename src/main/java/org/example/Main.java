package org.example;

import org.example.Alumnes.Alumne;
import org.example.Empleats.Empleat;
import org.example.Empleats.Professor;
import org.example.Files.Notes;
import org.example.Files.Turnos;
import org.example.Menu.Menu;

import java.io.*;
import java.sql.Array;
import java.sql.SQLOutput;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Scanner;

// si fas un canvi a una de les classes de objectes com la de alumne o la de professor has de borrar l archiu .dat d aquella classe per a que no peti
// fer un archiu .dat de tots els empleats i un per cada tipus d empleat
// no fa be lo dels profes

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Menu menu = new Menu();
        //Menu d' eleccio de rol
        int rol = menu.rolMenu();
        //menu d' opcions del usuari per rol
        int option = menu.optionsMenu(rol);

        if (rol == 1 && option == 1) { // ha loguejat un alumne // Raul

        } else if (rol == 1 && option == 2) {

        } else if (rol == 1 && option == 3) {

        } else if (rol == 1 && option == 4) {

        } else if (rol == 2 && option == 1) { // ha loguejat un profe //Abdel

            ArrayList<Alumne> alumnes = new ArrayList<>();
            File directoriAlumnes = new File("src/Files/alumnes.dat");
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
            }

            System.out.println("DNI del alumne del que vols veure les notes: ");
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
                File directoriNotes = new File("src/Files/notes.dat");

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
                        System.out.println("Les dades de l alumne son:" +  nota.getAlumne().toString() + " i te un " + nota.getNota() + " de nota");
                    }
                }

            } else {
                System.out.println("No s ha trobat cap alumne");
            }

        } else if (rol == 2 && option == 2) {

        } else if (rol == 2 && option == 3) {

        } else if (rol == 2 && option == 4) {

        } else if (rol == 3 && option == 1) { // ha logejat una cuinera // Raul

        } else if (rol == 3 && option == 2) {

        } else if (rol == 4 && option == 1) { // ha logejat una secretaria //Abdel

            ArrayList<Alumne> alumnes = new ArrayList<>();
            File directoriAlumnes = new File("src/Files/alumnes.dat");
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
                System.out.println("L alumne de DNI " + nif + " te aquestes dades: " + alumneTrobat.toString());
            } else {
                System.out.println("No s ha trobat cap alumne");
            }

        } else if (rol == 4 && option == 2) { // fer que no es sobreescribeixin els profes

            ArrayList<Professor> professors = new ArrayList<>();
            File directoriProfessors = new File("src/Files/professors.dat");
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
            } else {
                System.out.println("No s'ha trobat cap professor");
            }

        } else if (rol == 4 && option == 3) { // crear profes

            ArrayList<Professor> professors = new ArrayList<>();
            File directoriProfessors = new File("src/Files/professors.dat");

            try {
                if (directoriProfessors.exists()) {
                    FileInputStream fis = new FileInputStream(directoriProfessors);
                    ObjectInputStream ois = new ObjectInputStream(fis);

                    professors = (ArrayList<Professor>) ois.readObject();

                    ois.close();
                    fis.close();
                }
            } catch (EOFException e) {
                System.out.println("No hi han dades a professors.dat");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

            int numeroAssignatures = menu.obtindreInt("Quantes assignatures te aquest professor? ");
            String[] assignatures = new String[numeroAssignatures];
            System.out.println("Introdueix les assignatures que fa el professor: ");

            for (int i = 0; i < numeroAssignatures; i++) {
                assignatures[i] = menu.obtindreString("Assignatura: ");
            }

            Professor professor = new Professor(menu.nif(), menu.name(), menu.surname(), menu.email(), menu.age(), assignatures, menu.curs());
            professors.add(professor);

            try {
                FileOutputStream fos = new FileOutputStream(directoriProfessors);
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                oos.writeObject(professors);

                oos.close();
                fos.close();
                System.out.println("Has creat un professor amb aquestes dades: " + professor.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (rol == 4 && option == 4) {

            System.out.println("Dni del professor que vols actualitzar: ");
            String nif = menu.nif();
            ArrayList<Professor> professors = new ArrayList<>();
            File directoriProfessors = new File("src/Files/professors.dat");
            boolean trobat = false, acabat = false;

            try {

                FileInputStream fis = new FileInputStream(directoriProfessors);
                ObjectInputStream ois = new ObjectInputStream(fis);
                Professor professor = new Professor();

                while (!acabat) {
                    try {
                        professor = (Professor) ois.readObject();
                        professors.add(professor);
                    } catch (EOFException e) {
                        acabat = true;
                    }
                }

                ois.close();
                fis.close();
            } catch (EOFException e) {
                e.printStackTrace();
            }

            for (Professor professor : professors) {
                if (professor.getDni().equalsIgnoreCase(null)) {
                    System.out.println("No hi ha professors");
                }
                if (professor.getDni().equalsIgnoreCase(nif) && !trobat) {
                    trobat = true;
                    System.out.println("Pots actualitzar les dades del professor amb dni: " + professor.getDni());
                    professor.setDni(menu.nif());
                    professor.setNom(menu.name());
                    professor.setCognom(menu.surname());

                    int numeroAssignatures = menu.obtindreInt("Quantes assignatures te aquest professor? ");
                    String[] assignatures = new String[numeroAssignatures];
                    System.out.println("Introdueix les assignatures que fa el professor: ");
                    for (int i = 0; i < numeroAssignatures; i++) {
                        assignatures[i] = menu.obtindreString("Assignatura: ");
                    }

                    professor.setAssignatures(assignatures);
                    professor.setEdat(menu.age());
                    professor.setCurs(menu.curs());
                    System.out.println("El professor ara te aquestes dades: " + professor);

                    FileOutputStream fos = new FileOutputStream("src/Files/professors.dat", true);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(professor);

                    oos.close();
                    fos.close();
                }
            }
            if (!trobat) {
                System.out.println("No s ha trobat cap professor");
            }

        } else if (rol == 4 && option == 5) {

            ArrayList<Professor> professors = new ArrayList<>();
            File directoriProfessors = new File("src/Files/professors.dat");

            try {
                if (directoriProfessors.exists()) {
                    FileInputStream fis = new FileInputStream(directoriProfessors);
                    ObjectInputStream ois = new ObjectInputStream(fis);

                    professors = (ArrayList<Professor>) ois.readObject();

                    ois.close();
                    fis.close();
                }
            } catch (EOFException e) {
                System.out.println("No hi han dades a professors.dat");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

            System.out.println("Dni del professor que vols eliminar: ");
            String dni = menu.nif();
            int index = 0;
            boolean trobat = false;

            for (int i = 0; i < professors.size(); i++) {
                if (dni.equalsIgnoreCase(professors.get(i).getDni()) && !trobat) {
                    index = i;
                    trobat = true;
                }
            }

            if (trobat) {
                professors.remove(professors.get(index));
            } else {
                System.out.println("No s ha trobat al professor ");
            }

            try {
                FileOutputStream fos = new FileOutputStream(directoriProfessors);
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                oos.writeObject(professors);

                oos.close();
                fos.close();
                System.out.println("Has borrat al professor amb nif: " + dni);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (rol == 4 && option == 6) { // crear alumnes

            ArrayList<Alumne> alumnes = new ArrayList<>();
            File directoriAlumnes = new File("src/Files/alumnes.dat");

            try {
                if (directoriAlumnes.exists()) {
                    FileInputStream fis = new FileInputStream(directoriAlumnes);
                    ObjectInputStream ois = new ObjectInputStream(fis);

                    // Lee el ArrayList de alumnos existentes del archivo
                    alumnes = (ArrayList<Alumne>) ois.readObject();

                    ois.close();
                    fis.close();
                }
            } catch (EOFException e) {
                // No se encontraron datos en el archivo, no es un error.
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

            // Aquí puedes crear un nuevo alumno y agregarlo a la lista de "alumnes".
            Alumne alumne = new Alumne(menu.nif(), menu.name(), menu.surname(), menu.curs(), menu.age());
            alumnes.add(alumne);

            try {
                FileOutputStream fos = new FileOutputStream(directoriAlumnes);
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                oos.writeObject(alumnes);

                oos.close();
                fos.close();
                System.out.println("Has creat un alumne amb aquestes dades: " + alumne.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (rol == 4 && option == 7) {

            System.out.println("Dni del alumne que vols actualitzar: ");
            String nif = menu.nif();
            ArrayList<Alumne> alumnes = new ArrayList<>();
            File directoriAlumnes = new File("src/Files/alumnes.dat");
            boolean trobat = false, acabat = false;

            try { // s omple l arraylist amb alumnes del fitxer d alumnes

                FileInputStream fis = new FileInputStream(directoriAlumnes); // part per a pillar els alumnes
                ObjectInputStream ois = new ObjectInputStream(fis);
                Alumne alumne = new Alumne();

                while (!acabat) {
                    try {
                        alumne = (Alumne) ois.readObject();
                        alumnes.add(alumne);
                    } catch (EOFException e) {
                        acabat = true;
                    }
                }

                ois.close();
                fis.close();
            } catch (EOFException e) {
                e.printStackTrace();
            }

            for (Alumne alumne : alumnes) {
                if (alumne.getDni().equalsIgnoreCase(nif) && !trobat) {
                    trobat = true;
                    System.out.println("Pots actualitzar les dades de l' alumne amb dni: " + alumne.getDni());
                    alumne.setDni(menu.nif());
                    alumne.setNom(menu.name());
                    alumne.setCognom(menu.surname());
                    alumne.setCurs(menu.curs());
                    alumne.setEdat(menu.age());
                    System.out.println("L' alumne ara te aquestes dades: " + alumne);

                    FileOutputStream fos = new FileOutputStream("src/Files/alumnes.dat", true);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(alumnes);

                    oos.close();
                    fos.close();
                }
            }
            if (!trobat) {
                System.out.println("No s ha trobat cap alumne");
            }

        } else if (rol == 4 && option == 8) { // Raul

        } else if (rol == 4 && option == 9) {

        } else if (rol == 4 && option == 10) { // crear notes

            File directoriNotes = new File("src/Files/notes.dat");

            if (!directoriNotes.exists()) {
                try {
                    directoriNotes.createNewFile();
                } catch (EOFException e) {
                    e.printStackTrace();
                }
            }

            ArrayList<Alumne> alumnes = new ArrayList<>();
            File directoriAlumnes = new File("src/Files/alumnes.dat");
            int indexAlumneTrobat = 0;
            boolean trobat = false, acabat = false;


            try {
                if (directoriAlumnes.exists()) {
                    FileInputStream fis = new FileInputStream(directoriAlumnes);
                    ObjectInputStream ois = new ObjectInputStream(fis);

                    alumnes = (ArrayList<Alumne>) ois.readObject();

                    ois.close();
                    fis.close();
                }
            } catch (EOFException e) {
                System.out.println("No hi han dades a alumness.dat");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

            System.out.println("Nif del alumne del que vols crear les notes: ");
            String alumneToFind = menu.nif();
            for (int i = 0; i < alumnes.size(); i++) {
                if (alumnes.get(i).getDni().equalsIgnoreCase(alumneToFind) && !trobat) {
                    indexAlumneTrobat = i;
                    trobat = true;
                }
            }
            if (trobat) {
                int nota = menu.obtindreInt("Quina nota li vols ficar a l alumne? ");
                boolean valid = false;
                while (!valid) {
                    if (nota >= 0 && nota <= 10) {
                        valid = true;
                        Notes notesAlumne = new Notes(alumnes.get(indexAlumneTrobat), alumnes.get(indexAlumneTrobat).getCurs(), nota);
                        ArrayList<Notes> notesArrayList = new ArrayList<>();
                        notesArrayList.add(notesAlumne);
                        FileOutputStream fos = new FileOutputStream("src/Files/notes.dat", true);
                        ObjectOutputStream oos = new ObjectOutputStream(fos);

                        oos.writeObject(notesArrayList);

                        oos.close();
                        fos.close();
                    } else {
                        System.out.println("No has introduit un numero valid per a la nota");
                    }
                }
            } else {
                System.out.println("No s' ha trobat l alumne");
            }

        } else if (rol == 4 && option == 11) {

        } else if (rol == 4 && option == 12) {

        } else {
            System.out.println("No s ha pogut entrar");
        }
    }
}