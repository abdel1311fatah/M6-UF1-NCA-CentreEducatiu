package org.example;

import org.example.Alumnes.Alumne;
import org.example.Empleats.Empleat;
import org.example.Empleats.Professor;
import org.example.Files.Notes;
import org.example.Files.Turnos;
import org.example.Menu.Menu;

import java.io.*;
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
                Alumne alumne = new Alumne();

                while (!acabat){
                    try {
                        alumne = (Alumne) ois.readObject();
                        alumnes.add(alumne);
                    }catch (EOFException e){
                        acabat = true;
                    }
                }

                ois.close();
                fis.close();
            } catch (EOFException e) {
                e.printStackTrace();
            }

            System.out.println("DNI del alumne que vols trobar: ");
            String nif = menu.nif();

            if(alumnes.size() >= 0) {
                for (int i = 0; i < alumnes.size(); i++) {
                    if(nif.equalsIgnoreCase(alumnes.get(i).getDni()) && !trobat){
                        trobat = true;
                        indexAlumneTrobat = i;
                    }
                }
            }else{
                System.out.println("No hi han alumnes inscrits");
            }

            if (trobat){
                Alumne alumneTrobat = alumnes.get(indexAlumneTrobat);
                System.out.println("L alumne de DNI " + nif + " te aquestes dades: " + alumneTrobat.toString());
            }else{
                System.out.println("No s ha trobat cap alumne");
            }

        } else if (rol == 4 && option == 2) { // fer que no es sobreescribeixin els profes

            File directoriProfessors = new File("src/Files/professors.dat");

            if (!directoriProfessors.exists()) {
                directoriProfessors.createNewFile();
            }

            ArrayList<Professor> professors = new ArrayList<>();
            boolean trobat = false, acabat = false;

            try {

                FileInputStream fis = new FileInputStream(directoriProfessors);
                ObjectInputStream ois = new ObjectInputStream(fis);

                while (!acabat){
                    try {
                        professors.add((Professor) ois.readObject());
                    }catch (EOFException e){
                        acabat = true;
                    }
                }

                ois.close();
                fis.close();

            } catch (EOFException e) {
                e.printStackTrace();
            }

            System.out.println("DNI del profesor que vols trobar: ");
            String nif = menu.nif();

            for (Professor professor : professors) {
                if (professor.getDni() != null && professor.getDni().equalsIgnoreCase(nif)) {
                    trobat = true;
                    System.out.println("Professor trobat: " + professor.toString());
                }
            }

            if (!trobat) {
                System.out.println("No s'ha trobat cap professor amb aquest DNI.");
            }

        } else if (rol == 4 && option == 3) { // crear profes

            File directoriProfessors = new File("src/Files/professors.dat");
            if (!directoriProfessors.exists()) {
                directoriProfessors.createNewFile();
            }

            int numeroAssignatures = menu.obtindreInt("Quantes assignatures te aquest professor? ");
            String[] assignatures = new String[numeroAssignatures];
            System.out.println("Introdueix les assignatures que fa el professor: ");

            for (int i = 0; i < numeroAssignatures; i++) {
                assignatures[i] = menu.obtindreString("Assignatura: ");
            }

            Professor professor = new Professor(menu.nif(), menu.name(), menu.surname(), menu.email(), menu.age(),assignatures, menu.curs());

            FileOutputStream fos = new FileOutputStream(directoriProfessors, true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(professor);
            System.out.println("Has creat un professor amb aquestes dades: " + professor.toString()); // al escriure a professors.dat perd els atributs heredats

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

                while (!acabat){
                    try {
                        professor = (Professor) ois.readObject();
                        professors.add(professor);
                    }catch (EOFException e){
                        acabat = true;
                    }
                }

                ois.close();
                fis.close();
            } catch (EOFException e) {
                e.printStackTrace();
            }

            for (Professor professor : professors) {
                if(professor.getDni().equalsIgnoreCase(null)){
                    System.out.println("No hi ha professors");
                }
                if (professor.getDni().equalsIgnoreCase(nif) && !trobat){
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
            if (!trobat){
                System.out.println("No s ha trobat cap professor");
            }

        } else if (rol == 4 && option == 5) {

        } else if (rol == 4 && option == 6) { // crear alumnes

            File directoriAlumnes = new File("src/Files/alumnes.dat");
            if (!directoriAlumnes.exists()) {
                directoriAlumnes.createNewFile();
            }

            Alumne alumne = new Alumne(menu.nif(), menu.name(), menu.surname(), menu.curs(), menu.age());

            FileOutputStream fos = new FileOutputStream(directoriAlumnes, true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(alumne);
            System.out.println("Has creat un alumne amb aquestes dades: " + alumne.toString());

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

                while (!acabat){
                    try {
                        alumne = (Alumne) ois.readObject();
                        alumnes.add(alumne);
                    }catch (EOFException e){
                        acabat = true;
                    }
                }

                ois.close();
                fis.close();
            } catch (EOFException e) {
                e.printStackTrace();
            }

            for (Alumne alumne : alumnes) {
                if (alumne.getDni().equalsIgnoreCase(nif) && !trobat){
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
                    oos.writeObject(alumne);

                    oos.close();
                    fos.close();
                }
            }
            if (!trobat){
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

            try { // s omple l arraylist amb alumnes del fitxer d alumnes

                FileInputStream fis = new FileInputStream(directoriAlumnes); // part per a pillar els alumnes
                ObjectInputStream ois = new ObjectInputStream(fis);
                Alumne alumne = new Alumne();

                while (!acabat){
                    try {
                        alumne = (Alumne) ois.readObject();
                        alumnes.add(alumne);
                    }catch (EOFException e){
                        acabat = true;
                    }
                }

                ois.close();
                fis.close();
            } catch (EOFException e) {
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
            if(trobat) {
                Notes notesAlumne = new Notes(alumnes.get(indexAlumneTrobat), alumnes.get(indexAlumneTrobat).getCurs());
                FileOutputStream fos = new FileOutputStream("src/Files/notes.dat", true);
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                oos.writeObject(notesAlumne);

                oos.close();
                fos.close();
            }else{
                System.out.println("No s' ha trobat l alumne");
            }

        } else if (rol == 4 && option == 11) {

        } else if (rol == 4 && option == 12) {

        } else {
            System.out.println("No s ha pogut entrar");
        }
    }
}