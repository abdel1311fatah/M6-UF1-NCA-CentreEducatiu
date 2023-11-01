package org.example;

import org.example.Alumnes.Alumne;
import org.example.Empleats.Empleat;
import org.example.Files.Notes;
import org.example.Files.Turnos;
import org.example.Menu.Menu;

import java.io.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Scanner;

// si fas un canvi a una de les classes de objectes com la de alumne o la de professor has de borrar l archiu .dat d aquella classe per a que no peti
// fer un archiu .dat de tots els empleats i un per cada tipus d empleat

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Menu menu = new Menu();
        //Menu d' eleccio de rol
        int rol = menu.rolMenu();
        //menu d' opcions del usuari i creem el hashmap que te el rol de l usuari i la opcio que vol fer
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

        } else if (rol == 4 && option == 2) { // recorrem els arxius de turnos i de empleats i comparem el dni del empleat al que li tocarie el turno amb el del empleat a buscar // aixo es per a crear torns

            System.out.println("DNI del empleat del que vols mirar els torns: ");
            String nif = menu.nif();

            ArrayList<Turnos> torns = new ArrayList<>();
            File directoriTorns = new File("src/Files/torns.dat");
            Boolean acabat = false;

            if(!directoriTorns.exists()){
                try {
                    directoriTorns.createNewFile();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }

            try {
                FileInputStream fis = new FileInputStream(directoriTorns);
                ObjectInputStream ois = new ObjectInputStream(fis);
                Turnos torn = new Turnos();

                while (!acabat){
                    try {
                        torn = (Turnos) ois.readObject();
                        torns.add(torn);
                    }catch (EOFException e){
                        acabat = true;
                    }
                }

                ois.close();
                fis.close();
            } catch (EOFException e) {
                e.printStackTrace();
            }

            if(torns.size() >= 0) {
                for (int i = 0; i < torns.size(); i++) {
                    if(nif.equalsIgnoreCase(torns.get(i).getDni())){
                        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                        Turnos torn = new Turnos(nif, timestamp);
                        FileOutputStream fos = new FileOutputStream(directoriTorns);
                        ObjectOutputStream oos = new ObjectOutputStream(fos);

                        oos.writeObject(torn);
                    }
                }
            }

        } else if (rol == 4 && option == 3) {

        } else if (rol == 4 && option == 4) {

        } else if (rol == 4 && option == 5) {

        } else if (rol == 4 && option == 6) {

        } else if (rol == 4 && option == 7) { // crear alumnes

            File directoriAlumnes = new File("src/Files/alumnes.dat");
            if (!directoriAlumnes.exists()) {
                directoriAlumnes.createNewFile();
            }

            Alumne alumne = new Alumne(menu.nif(), menu.name(), menu.surname(), menu.curs(), menu.age());

            FileOutputStream fos = new FileOutputStream(directoriAlumnes);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(alumne);

        } else if (rol == 4 && option == 8) { // Raul

        } else if (rol == 4 && option == 9) {

        } else if (rol == 4 && option == 10) {

        } else if (rol == 4 && option == 11) { // crear notes

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

            String alumneToFind = menu.name();
            for (int i = 0; i < alumnes.size(); i++) {
                if (alumnes.get(i).getNom().equalsIgnoreCase(alumneToFind)) {
                    indexAlumneTrobat = i;
                }
            }

            Notes notesAlumne = new Notes(alumnes.get(indexAlumneTrobat), "Matematiques", 7);
            FileOutputStream fos = new FileOutputStream("notes.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(notesAlumne);

            oos.close();
            fos.close();

        } else if (rol == 4 && option == 12) {

        } else if (rol == 4 && option == 13) {

        } else {
            System.out.println("No s ha pogut entrar");
        }
    }
}