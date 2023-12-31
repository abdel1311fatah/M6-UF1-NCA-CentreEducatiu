package org.example;

import org.example.Alumnes.Alumne;
import org.example.Empleats.Professor;
import org.example.Files.Deures;
import org.example.Files.Horari;
import org.example.Files.Notes;
import org.example.Menu.Menu;

import java.io.*;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class CentreEducatiu {

    public CentreEducatiu() {
    }

    Menu menu = new Menu();

    public Optional<Notes> mirarNotes() throws IOException, ClassNotFoundException {
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
                    return Optional.of(nota);
                }
            }

        } else {
            System.out.println("No s'ha trobat cap alumne");
        }

        return null;
    }

    public Optional<Professor> mirarProfessor() throws IOException, ClassNotFoundException {
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
        Professor professorTrobat = null;
        if (trobat) {
            professorTrobat = professors.get(indexProfessorTrobat);
            System.out.println("El professor de DNI " + nif + " te aquestes dades: " + professorTrobat.toString());
            return Optional.of(professorTrobat);
        } else {
            System.out.println("No s'ha trobat cap professor");
        }
        return Optional.ofNullable(professorTrobat);
    }

    public Optional<Alumne> mirarAlumne() throws IOException, ClassNotFoundException {
        ArrayList<Alumne> alumnes = new ArrayList<>();
        File directoriAlumnes = new File(menu.ruta() + "alumnes.dat");
        int indexAlumneTrobat = 0;
        boolean trobat = false, acabat = false;

        if (!directoriAlumnes.exists()) {
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

        Alumne alumneTrobat = null;
        if (trobat) {
            alumneTrobat = alumnes.get(indexAlumneTrobat);
            System.out.println("L'alumne de DNI " + nif + " te aquestes dades: " + alumneTrobat.toString());
        } else {
            System.out.println("No s ha trobat cap alumne");
        }
        return Optional.ofNullable(alumneTrobat);
    }

    public Optional<Horari> mirarHorari() throws IOException, ClassNotFoundException {
        ArrayList<Horari> horaris = new ArrayList<>();
        File directoriProfessors = new File(menu.ruta() + "horari.dat");
        int indexHorariTrobat = 0;
        boolean trobat = false;

        try {
            FileInputStream fis = new FileInputStream(directoriProfessors);
            ObjectInputStream ois = new ObjectInputStream(fis);

            horaris = (ArrayList<Horari>) ois.readObject();

            ois.close();
            fis.close();
        } catch (EOFException e) {
            e.printStackTrace();
        }

        String assignatura = menu.obtindreString("Assignatura de la que vols mirar el horari: ");

        if (horaris.size() >= 0) {
            for (int i = 0; i < horaris.size(); i++) {
                if (assignatura.equalsIgnoreCase(horaris.get(i).getAssignatura()) && !trobat) {
                    trobat = true;
                    indexHorariTrobat = i;
                }
            }
        } else {
            System.out.println("No hi han horaris ficats");
        }

        if (trobat) {
            Horari horari = horaris.get(indexHorariTrobat);
            System.out.println("L' assignatura " + horari.getAssignatura() + " toca a la hora " + horari.getHora());
            return Optional.of(horari);
        } else {
            System.out.println("No s'ha trobat cap horari");
        }
        return null;
    }

    public ArrayList<Professor> crearProfessor() {
        boolean valid = false;
        ArrayList<Professor> professors = new ArrayList<>();
        File directoriProfessors = new File(menu.ruta() + "professors.dat");
        while (!valid) {

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
                valid = true;
            } catch (IOException e) {
                System.out.println("No s' ha pogut crear el professor, torna a intentar: ");
            }
        }
        return professors;
    }

    public ArrayList<Professor> updateProfessor() throws IOException {
        Boolean valid = false;
        ArrayList<Professor> professors = new ArrayList<>();

        while (!valid) {
            System.out.println("Dni del professor que vols actualitzar: ");
            String nif = menu.nif();

            File directoriProfessors = new File(menu.ruta() + "professors.dat");
            boolean trobat = false;

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

            for (Professor professor : professors) {
                if (professor.getDni().isEmpty()) {
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
                    valid = true;
                }
            }
            if (!trobat) {
                System.out.println("No s'ha trobat cap professor");
            }
        }
        return professors;
    }

    public ArrayList<Professor> deleteProfessor() {
        boolean valid = false;
        ArrayList<Professor> professors = new ArrayList<>();
        File directoriProfessors = new File(menu.ruta() + "professors.dat");
        while (!valid) {
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
                valid = true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return professors;
    }

    public ArrayList<Alumne> crearAlumne() {
        boolean valid = false;
        ArrayList<Alumne> alumnes = new ArrayList<>();
        File directoriAlumnes = new File(menu.ruta() + "alumnes.dat");
        while (!valid) {
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
                valid = true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return alumnes;
    }

    public ArrayList<Alumne> updateAlumne() throws IOException, ClassNotFoundException {
        boolean valid = false;
        ArrayList<Alumne> alumnes = new ArrayList<>();
        File directoriAlumnes = new File(menu.ruta() + "alumnes.dat");

        while (!valid) {
            System.out.println("Dni del alumne que vols actualitzar: ");
            String nif = menu.nif();

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
                    valid = true;
                }
            }
            if (!trobat) {
                System.out.println("No s'ha trobat cap alumne");
            }
        }
        return alumnes;
    }

    public ArrayList<Alumne> deleteAlumne() {
        boolean valid = false;
        ArrayList<Alumne> alumnes = new ArrayList<>();
        File directoriAlumnes = new File(menu.ruta() + "alumnes.dat");

        while (!valid) {
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
                valid = true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return alumnes;
    }

    public ArrayList<Notes> deleteNota() {

        boolean valid = false;
        ArrayList<Notes> notas = new ArrayList<>();
        File archivoNotas = new File(menu.ruta() + "notes.dat");

        while (!valid) {
            // Demana el DNI de les notes que vols borrar
            System.out.println("DNI del alumne al que vols borrar les notes: ");
            String dniAlumno = menu.nif();


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
                valid = true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return notas;
    }

    public ArrayList<Notes> crearNota() throws IOException {
        boolean valid = false;
        File directoriNotes = new File(menu.ruta() + "notes.dat");
        ArrayList<Notes> notesArrayList = new ArrayList<>();

        while (!valid) {

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
                boolean notaValida = false;
                while (!notaValida) {
                    if (nota >= 0 && nota <= 10) {
                        notaValida = true;
                        Notes notesAlumne = new Notes(alumnes.get(indexAlumneTrobat), alumnes.get(indexAlumneTrobat).getCurs(), nota);

                        notesArrayList.add(notesAlumne);
                        FileOutputStream fos = new FileOutputStream(menu.ruta() + "notes.dat", true);
                        ObjectOutputStream oos = new ObjectOutputStream(fos);

                        oos.writeObject(notesArrayList);

                        oos.close();
                        fos.close();
                        valid = true;
                    } else {
                        nota = menu.obtindreInt("No has introduit un numero válid per a la nota, introdueixne un altra: ");
                    }
                }
            } else {
                System.out.println("No s'ha trobat l'alumne");
            }
        }
        return notesArrayList;
    }

    public ArrayList<Notes> updateNotes() {
        boolean valid = false;
        ArrayList<Notes> notas = new ArrayList<>();
        File archivoNotas = new File(menu.ruta() + "notes.dat");

        while (!valid) {
            // Demana el DNI que volem actualitzar
            System.out.println("DNI del alumne del que vols actualitzar les notes: ");
            String dniAlumno = menu.nif();

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
                    System.out.println("Introdueix la nova nota per el curs " + nota.getCurs() + ": ");
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
                    valid = true;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("No s'han trobat el dni de les notes del alumne al que actualitzar: " + dniAlumno);
            }
        }
        return notas;
    }

    public ArrayList<Horari> crearHorari() {
        boolean valid = false;
        ArrayList<Horari> horaris = new ArrayList<>();
        File directoriHorari = new File(menu.ruta() + "horari.dat");
        while (!valid) {
            try {
                if (directoriHorari.exists()) {
                    FileInputStream fis = new FileInputStream(directoriHorari);
                    ObjectInputStream ois = new ObjectInputStream(fis);

                    // llegeix l'array list d'horaris
                    horaris = (ArrayList<Horari>) ois.readObject();

                    ois.close();
                    fis.close();
                }
            } catch (EOFException e) {
                // No s'han trobat les dades del horari
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

            // Crear un nou horari y agregarlo a "horaris"
            Horari horari = new Horari(menu.obtindreInt("Introdueix la hora de la asignatura: "), menu.obtindreString("Introdueix la asignatura corresponent: "));
            horaris.add(horari);

            try {
                FileOutputStream fos = new FileOutputStream(directoriHorari);
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                oos.writeObject(horaris);

                oos.close();
                fos.close();
                System.out.println("Has creat un alumne amb aquestes dades: " + horari.toString());
                valid = true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return horaris;
    }

    public ArrayList<Horari> borrarHorari() {
        boolean valid = false;
        ArrayList<Horari> horaris = new ArrayList<>();
        File directoriHorari = new File(menu.ruta() + "horari.dat");

        while (!valid) {
            try {
                if (directoriHorari.exists()) {
                    FileInputStream fis = new FileInputStream(directoriHorari);
                    ObjectInputStream ois = new ObjectInputStream(fis);

                    horaris = (ArrayList<Horari>) ois.readObject();

                    ois.close();
                    fis.close();
                }
            } catch (EOFException e) {
                System.out.println("No hi han dades a horari.dat");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

            System.out.println("Nom de la asignatura que vols borrar: ");
            String dni = menu.nif();
            int index = 0;
            boolean trobat = false;

            for (int i = 0; i < horaris.size(); i++) {
                if (dni.equalsIgnoreCase(horaris.get(i).getAssignatura()) && !trobat) {
                    index = i;
                    trobat = true;
                }
            }

            if (trobat) {
                horaris.remove(horaris.get(index));
            } else {
                System.out.println("No s'ha trobat al professor ");
            }

            try {
                FileOutputStream fos = new FileOutputStream(directoriHorari);
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                oos.writeObject(horaris);

                oos.close();
                fos.close();
                System.out.println("Has borrat la assignatura: " + dni);
                valid = true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return horaris;
    }

    public ArrayList<Horari> ActualitzarHorari() throws IOException, ClassNotFoundException {
        boolean valid = false;
        ArrayList<Horari> horaris = new ArrayList<>();
        File directoriHorari = new File(menu.ruta() + "horari.dat");

        while (!valid) {
            System.out.print("Nom de la assignatura que vols actualitzar: ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String assignatura = reader.readLine();

            boolean trobat = false, acabat = false;

            try {
                FileInputStream fis = new FileInputStream(directoriHorari);
                ObjectInputStream ois = new ObjectInputStream(fis);

                horaris = (ArrayList<Horari>) ois.readObject();

                ois.close();
                fis.close();
            } catch (EOFException e) {
                e.printStackTrace();
            }

            for (Horari horari : horaris) {
                if (horari.getAssignatura().equalsIgnoreCase(assignatura) && !trobat) {
                    trobat = true;
                    System.out.println("Pots actualitzar les dades de l'assignatura: " + horari.getAssignatura());

                    System.out.print("Introdueix la nova hora: ");
                    int novaHora = Integer.parseInt(reader.readLine());// Solicita la nueva hora al usuario
                    horari.setHora(novaHora); // Actualiza la hora del horario

                    System.out.println("L'assignatura ara té aquestes dades: " + horari);

                    FileOutputStream fos = new FileOutputStream(menu.ruta() + "horari.dat", false); // Usar 'false' para reemplazar el archivo
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(horaris);

                    oos.close();
                    fos.close();
                    valid = true;
                }
            }
            if (!trobat) {
                System.out.println("No s'ha trobat cap assignatura");
            }
        }
        return horaris;
    }

    public ArrayList<Deures> crearDeures() {
        boolean valid = false;
        ArrayList<Deures> deures = new ArrayList<>();
        File directoriDeures = new File(menu.ruta() + "deures.dat");
        while (!valid) {
            try {
                if (directoriDeures.exists()) {
                    FileInputStream fis = new FileInputStream(directoriDeures);
                    ObjectInputStream ois = new ObjectInputStream(fis);

                    // llegeix l'array list d'alumnes
                    deures = (ArrayList<Deures>) ois.readObject();

                    ois.close();
                    fis.close();
                }
            } catch (EOFException e) {
                // No s'han trobat les dades del alumne
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

            //Trobar al professor per a la tasca
            ArrayList<Professor> professors = new ArrayList<>();
            System.out.println("Ara introdueix la ruta on tens guardats els profesors ");
            File directoriProfessors = new File(menu.ruta() + "professors.dat ");
            int indexProfessorTrobat = 0;
            boolean trobat = false;

            try {
                FileInputStream fis = new FileInputStream(directoriProfessors);
                ObjectInputStream ois = new ObjectInputStream(fis);

                professors = (ArrayList<Professor>) ois.readObject();

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

            String assignatura = menu.obtindreString("Assignatura del professor del que vols mirar la tasca ");

            if (professors.size() >= 0) {
                for (int i = 0; i < professors.size(); i++) {
                    String[] assignatures = professors.get(i).getAssignatures();
                    for (int j = 0; j < assignatures.length; j++) {
                        if (assignatures[j].equalsIgnoreCase(assignatura) && !trobat) {
                            trobat = true;
                            indexProfessorTrobat = i;
                        }
                    }
                }
            } else {
                System.out.println("No hi han professors inscrits ");
            }

            if (trobat) {
                Deures tasca = new Deures(assignatura, professors.get(indexProfessorTrobat));
                deures.add(tasca);
            } else {
                System.out.println("No s han pogut crear els deures ");
            }

            try {
                FileOutputStream fos = new FileOutputStream(directoriDeures);
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                oos.writeObject(deures);

                oos.close();
                fos.close();
                System.out.println("Has creats aquesta tasca: " + deures.get(indexProfessorTrobat).toString());
                valid = true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return deures;
    }

    public ArrayList<Deures> mirarDeures() {

        ArrayList<Deures> deures = new ArrayList<>();
        File directoriDeures = new File(menu.ruta() + "deures.dat");
        try {
            if (directoriDeures.exists()) {
                FileInputStream fis = new FileInputStream(directoriDeures);
                ObjectInputStream ois = new ObjectInputStream(fis);

                // llegeix l'array list d'alumnes
                deures = (ArrayList<Deures>) ois.readObject();

                ois.close();
                fis.close();
            }
        } catch (EOFException e) {
            // No s'han trobat les dades del alumne
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        //Trobar al professor per a la tasca
        ArrayList<Professor> professors = new ArrayList<>();
        System.out.println("Ara introdueix la ruta d' on vols treure els professors");
        File directoriProfessors = new File(menu.ruta() + "professors.dat");
        boolean trobat = false;

        try {
            FileInputStream fis = new FileInputStream(directoriProfessors);
            ObjectInputStream ois = new ObjectInputStream(fis);

            professors = (ArrayList<Professor>) ois.readObject();

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

        ArrayList<Deures> tasquesProfessor = new ArrayList<>();

        String assignatura = menu.obtindreString("Assignatura del professor del que vols mirar la tasca ");

        if (professors.size() >= 0) {
            for (int i = 0; i < professors.size(); i++) {
                String[] assignatures = professors.get(i).getAssignatures();
                for (int j = 0; j < assignatures.length; j++) {
                    if(assignatures[j].equalsIgnoreCase(assignatura) && !trobat){
                        Deures tasca = new Deures();
                        tasca.setAssignatura(assignatures[j]);
                        tasca.setProfessor(professors.get(i));
                        tasquesProfessor.add(tasca);
                        trobat = true;
                    }
                }
            }
        } else {
            System.out.println("No s ha trobat cap tasca d' aquesta assignatura ");
        }

        if(trobat) {
            for (Deures tasca : tasquesProfessor) {
                System.out.println("Tens aquesta tasca: " + tasca.toString());
            }
        }

        return tasquesProfessor;

    }

    public ArrayList<Deures> deleteDeures(){
        boolean valid = false;
        ArrayList<Deures> deures = new ArrayList<>();
        File directoriDeures = new File(menu.ruta() + "deures.dat");
        while (!valid) {
            try {
                if (directoriDeures.exists()) {
                    FileInputStream fis = new FileInputStream(directoriDeures);
                    ObjectInputStream ois = new ObjectInputStream(fis);

                    deures = (ArrayList<Deures>) ois.readObject();

                    ois.close();
                    fis.close();
                }
            } catch (EOFException e) {
                System.out.println("No queden dades a deures.dat");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

            String assignatura = menu.obtindreString("Introdueix el nom de l' assignatura de la que vols eliminar els deures: ");
            int index = 0;
            boolean trobat = false;

            for (int i = 0; i < deures.size(); i++) {
                if (assignatura.equalsIgnoreCase(deures.get(i).getAssignatura()) && !trobat) {
                    index = i;
                    trobat = true;
                }
            }

            if (trobat) {
                deures.remove(deures.get(index));
            } else {
                System.out.println("No s'ha trobat al professor ");
            }

            try {
                FileOutputStream fos = new FileOutputStream(directoriDeures);
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                oos.writeObject(deures);

                oos.close();
                fos.close();
                System.out.println("Has borrat les tasques de l' assignatura: " + assignatura);
                valid = true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return deures;
    }

}
