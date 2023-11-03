package org.example;

import org.example.Alumnes.Alumne;
import org.example.Empleats.Empleat;
import org.example.Empleats.Professor;
import org.example.Files.Notes;
import org.example.Menu.Menu;
import java.io.*;
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

        if (rol == 1 && option == 1) {

            ArrayList<Alumne> alumnes = new ArrayList<>();
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
                        System.out.println("Les dades del alumne son:" +  nota.getAlumne().toString() + " i te un " + nota.getNota() + " de nota");
                    }
                }

            } else {
                System.out.println("No s'ha trobat cap alumne");
            }

        } else if (rol == 1 && option == 2) {

        } else if (rol == 1 && option == 3) {

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
            } else {
                System.out.println("No s'ha trobat cap professor");
            }

        } else if (rol == 1 && option == 4) {

        } else if (rol == 2 && option == 1) { // ha loguejat un profe //Abdel

            ArrayList<Alumne> alumnes = new ArrayList<>();
            File directoriAlumnes = new File(menu.ruta() + "alumnes.dat");
            int indexAlumneTrobat = 0;
            boolean trobat = false, acabat = false;

            try { // s'omple arraylist amb alumnes del fitxer d alumnes

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
                        System.out.println("Les dades del alumne son:" +  nota.getAlumne().toString() + " i te un " + nota.getNota() + " de nota");
                    }
                }

            } else {
                System.out.println("No s ha trobat cap alumne");
            }

        } else if (rol == 2 && option == 2) {

        } else if (rol == 2 && option == 3) {

            ArrayList<Alumne> alumnes = new ArrayList<>();
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
            } else {
                System.out.println("No s ha trobat cap alumne");
            }

        } else if (rol == 3 && option == 1) { // ha logejat una cuinera // Raul

        } else if (rol == 3 && option == 2) {

        } else if (rol == 4 && option == 1) { // ha logejat una secretaria //Abdel

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
            } else {
                System.out.println("No s ha trobat cap alumne");
            }

        } else if (rol == 4 && option == 2) { // fer que no es sobreescribeixin els profes

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
            } else {
                System.out.println("No s'ha trobat cap professor");
            }

        } else if (rol == 4 && option == 3) { // crear profes

            ArrayList<Professor> professors = new ArrayList<>();
            File directoriProfessors = new File(menu.ruta() + "professors.dat");

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
            File directoriProfessors = new File(menu.ruta() + "professors.dat");
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
                    System.out.println("Les dades del professor han sigut actualitzades a: " + professor);

                    FileOutputStream fos = new FileOutputStream(menu.ruta() + "professors.dat", true);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(professor);

                    oos.close();
                    fos.close();
                }
            }
            if (!trobat) {
                System.out.println("No s'ha trobat cap professor");
            }

        } else if (rol == 4 && option == 5) {

            ArrayList<Professor> professors = new ArrayList<>();
            File directoriProfessors = new File(menu.ruta() + "professors.dat");

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
                System.out.println("No s'ha trobat al professor ");
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
            File directoriAlumnes = new File(menu.ruta() + "alumnes.dat");

            try {
                if (directoriAlumnes.exists()) {
                    FileInputStream fis = new FileInputStream(directoriAlumnes);
                    ObjectInputStream ois = new ObjectInputStream(fis);

                    // llegeix l'array list d'alumnes
                    alumnes = (ArrayList<Alumne>) ois.readObject();

                    ois.close();
                    fis.close();
                }
            } catch (EOFException e) {
                // No s'han trobat les dades del alumne
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

            // Crear un nou alumne y agregarlo a "alumnes"
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
            File directoriAlumnes = new File(menu.ruta() + "alumnes.dat");
            boolean trobat = false, acabat = false;

            try { // s'ompla la arraylist amb alumnes del fitxer d alumnes

                FileInputStream fis = new FileInputStream(directoriAlumnes); // part per a pillar els alumnes
                ObjectInputStream ois = new ObjectInputStream(fis);

                alumnes = (ArrayList<Alumne>) ois.readObject();

                ois.close();
                fis.close();
            } catch (EOFException e) {
                e.printStackTrace();
            }

            for (Alumne alumne : alumnes) {
                if (alumne.getDni().equalsIgnoreCase(nif) && !trobat) {
                    trobat = true;
                    System.out.println("Pots actualitzar les dades de l' alumne amb dni: " + alumne.getDni());
                    alumne.setNom(menu.name());
                    alumne.setCognom(menu.surname());
                    alumne.setCurs(menu.curs());
                    alumne.setEdat(menu.age());
                    System.out.println("L'alumne ara te aquestes dades: " + alumne);

                    FileOutputStream fos = new FileOutputStream(menu.ruta() + "alumnes.dat", true);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(alumnes);

                    oos.close();
                    fos.close();
                }
            }
            if (!trobat) {
                System.out.println("No s'ha trobat cap alumne");
            }

        } else if (rol == 4 && option == 8) { // Raul

            ArrayList<Alumne> alumnes = new ArrayList<>();
            File directoriAlumnes = new File(menu.ruta() + "alumnes.dat");

            try {
                if (directoriAlumnes.exists()) {
                    FileInputStream fis = new FileInputStream(directoriAlumnes);
                    ObjectInputStream ois = new ObjectInputStream(fis);

                    alumnes = (ArrayList<Alumne>) ois.readObject();

                    ois.close();
                    fis.close();
                }
            } catch (EOFException e) {
                System.out.println("No hi han dades a alumnes.dat");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

            System.out.println("Dni del alumne que vols eliminar: ");
            String dni = menu.nif();
            int index = 0;
            boolean trobat = false;

            for (int i = 0; i < alumnes.size(); i++) {
                if (dni.equalsIgnoreCase(alumnes.get(i).getDni()) && !trobat) {
                    index = i;
                    trobat = true;
                }
            }

            if (trobat) {
                alumnes.remove(alumnes.get(index));
            } else {
                System.out.println("No s'ha trobat al professor ");
            }

            try {
                FileOutputStream fos = new FileOutputStream(directoriAlumnes);
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                oos.writeObject(alumnes);

                oos.close();
                fos.close();
                System.out.println("Has borrat al alumne amb nif: " + dni);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (rol == 4 && option == 9) {
            // Demana el DNI de les notes que vols borrar
            System.out.println("DNI del alumne al que vols borrar les notes: ");
            String dniAlumno = menu.nif();

            ArrayList<Notes> notas = new ArrayList<>();
            File archivoNotas = new File(menu.ruta() + "notes.dat");

            try {
                if (archivoNotas.exists()) {
                    FileInputStream fis = new FileInputStream(archivoNotas);
                    ObjectInputStream ois = new ObjectInputStream(fis);

                    // Llegir les notes existents del arxiu
                    notas = (ArrayList<Notes>) ois.readObject();
                    ois.close();
                    fis.close();
                }
            } catch (EOFException e) {
                System.out.println("No hi ha dades en notes.dat");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

            // Itera sobre les notes y borra la correspondent amb el ID
            ArrayList<Notes> notasABorrar = new ArrayList<>();
            for (Notes nota : notas) {
                if (nota.getAlumne().getDni().equalsIgnoreCase(dniAlumno)) {
                    notasABorrar.add(nota);
                }
            }

            // Elimina les notes que em seleccionat
            notas.removeAll(notasABorrar);

            try {
                // Tornar a escriure la llista actualitzada
                FileOutputStream fos = new FileOutputStream(archivoNotas);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(notas);
                oos.close();
                fos.close();

                System.out.println("S'han borrat les notes del alumne: " + dniAlumno);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (rol == 4 && option == 10) { // crear notes

            File directoriNotes = new File(menu.ruta() + "notes.dat");

            if (!directoriNotes.exists()) {
                try {
                    directoriNotes.createNewFile();
                } catch (EOFException e) {
                    e.printStackTrace();
                }
            }

            ArrayList<Alumne> alumnes = new ArrayList<>();
            File directoriAlumnes = new File(menu.ruta() + "alumnes.dat");
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
                int nota = menu.obtindreInt("Quina nota li vols ficar al alumne? ");
                boolean valid = false;
                while (!valid) {
                    if (nota >= 0 && nota <= 10) {
                        valid = true;
                        Notes notesAlumne = new Notes(alumnes.get(indexAlumneTrobat), alumnes.get(indexAlumneTrobat).getCurs(), nota);
                        ArrayList<Notes> notesArrayList = new ArrayList<>();
                        notesArrayList.add(notesAlumne);
                        FileOutputStream fos = new FileOutputStream(menu.ruta() + "notes.dat", true);
                        ObjectOutputStream oos = new ObjectOutputStream(fos);

                        oos.writeObject(notesArrayList);

                        oos.close();
                        fos.close();
                    } else {
                        nota = menu.obtindreInt("No has introduit un numero válid per a la nota, introdueixne un altra: ");
                    }
                }
            } else {
                System.out.println("No s'ha trobat l'alumne");
            }

        } else if (rol == 4 && option == 11) {
            // Demana el DNI que volem actualitzar
            System.out.println("DNI del alumne del que vols actualitzar les notes: ");
            String dniAlumno = menu.nif();

            ArrayList<Notes> notas = new ArrayList<>();
            File archivoNotas = new File(menu.ruta() + "notes.dat");

            try {
                if (archivoNotas.exists()) {
                    FileInputStream fis = new FileInputStream(archivoNotas);
                    ObjectInputStream ois = new ObjectInputStream(fis);

                    // Llegir les notes existents
                    notas = (ArrayList<Notes>) ois.readObject();
                    ois.close();
                    fis.close();
                }
            } catch (EOFException e) {
                System.out.println("No hi ha dates en notes.dat");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

            // Busca les notes del alumne y les actualitza per una nova.
            boolean notasActualizadas = false;
            for (Notes nota : notas) {
                if (nota.getAlumne().getDni().equalsIgnoreCase(dniAlumno)) {
                    // Demana la nova nota y actualitza la existent
                    System.out.println("Introdueix la novaa nota per el curs " + nota.getCurs() + ": ");
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Nova nota: ");
                    int nuevaNota = scanner.nextInt();
                    nota.setNota(nuevaNota);
                    notasActualizadas = true;
                }
            }

            if (notasActualizadas) {
                try {
                    // Torna a escriure la llista de notes actualitzades
                    FileOutputStream fos = new FileOutputStream(archivoNotas);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(notas);
                    oos.close();
                    fos.close();

                    System.out.println("Se han actualitzat les notes del alumne: " + dniAlumno);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("No s'han trobat el dni de les notes del alumne al que actualitzar: " + dniAlumno);
            }
        } else if (rol == 4 && option == 12) {
            ArrayList<Notes> allNotes = new ArrayList<>();
            File directoriNotes = new File(menu.ruta() + "notes.dat");

            try {
                FileInputStream fis = new FileInputStream(directoriNotes);
                ObjectInputStream ois = new ObjectInputStream(fis);

                allNotes = (ArrayList<Notes>) ois.readObject();

                ois.close();
                fis.close();
            } catch (EOFException e) {
                e.printStackTrace();
            }

            for (Notes nota : allNotes) {
                System.out.println("Les notes dels alumnes son: " + nota.getAlumne().toString() + " y tenen una nota de " + nota.getNota());
            }
        } else {
            System.out.println("No s'ha pogut entrar");
        }
    }
}