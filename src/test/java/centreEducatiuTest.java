import org.example.Alumnes.Alumne;
import org.example.Empleats.Professor;
import org.example.Files.Horari;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class centreEducatiuTest {

    centreEducatiuTest() {
    }

    @BeforeEach
    void setUpAlumnes() { // borrem el archiu d alumnes abans de cada test per a que compari be al foreach
        File file = new File("src/Files/alumnes.dat");
        if (file.exists()) {
            file.delete();
        }
    }

    @BeforeEach
    void setUpProfessors() {
        File file = new File("src/Files/professors.dat");
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    void createAlumneTest() { // fer el d alumne i aadaptar els altres amb chatgpt
        Alumne expectedAlumne = new Alumne("49535056w", "Abdel", "Fatah", "it", 18);
        ArrayList<Alumne> expectedAlumnes = crearAlumne("src/Files/alumnes.dat");
        ArrayList<Alumne> alumnes = new ArrayList<>();
        File directoriAlumnes = new File("src/Files/alumnes.dat");

        if (directoriAlumnes.exists()) {
            try {
                FileInputStream fis = new FileInputStream(directoriAlumnes);
                ObjectInputStream ois = new ObjectInputStream(fis);

                alumnes = (ArrayList<Alumne>) ois.readObject();

                ois.close();
                fis.close();
            } catch (EOFException e) {
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < expectedAlumnes.size(); i++) {
            assertTrue(expectedAlumnes.get(i).equals(alumnes.get(i)));
        }
    }

    @Test
    void createProfessorTest() {
        Professor expectedProfessor = new Professor("12345678X", "Juan", "Pérez", "juan@example.com", 40, new String[]{"Matemáticas", "Física"}, "3A");
        ArrayList<Professor> expectedProfessors = createProfessor("src/Files/professors.dat");
        ArrayList<Professor> professors = new ArrayList<>();
        File professorsFile = new File("src/Files/professors.dat");

        if (professorsFile.exists()) {
            try {
                FileInputStream fis = new FileInputStream(professorsFile);
                ObjectInputStream ois = new ObjectInputStream(fis);

                professors = (ArrayList<Professor>) ois.readObject();

                ois.close();
                fis.close();
            } catch (EOFException e) {
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < expectedProfessors.size(); i++) {
            assertTrue(expectedProfessors.get(i).equals(professors.get(i)));
        }
    }

    @Test
    void mirarAlumnesTest() throws IOException, ClassNotFoundException {
        Optional<Alumne> alumneBuscat = mirarAlumne();
        Alumne expectedAlumne = new Alumne("49535056w", "Abdel", "Fatah", "it", 18);
        assertTrue(alumneBuscat.get().equals(expectedAlumne));
    }

    @Test
    void updateProfessorTest() throws IOException, ClassNotFoundException {

        String[] assignatures = {"mates", "fisica"};
        Professor expectedProfessor = new Professor("00000000T", "Manolilla", "Dianabol", "e@e", 30, assignatures, "it");
        createProfessor("src/Files/professors.dat");
        ArrayList<Professor> professors = updateProfessor();

        for (Professor professor : professors) {
            assertTrue(professor.equals(expectedProfessor));
        }

    }

    public ArrayList<Alumne> crearAlumne(String filePath) {
        ArrayList<Alumne> alumnes = new ArrayList<>();
        File directoriAlumnes = new File(filePath);

        if (directoriAlumnes.exists()) {
            try {
                FileInputStream fis = new FileInputStream(directoriAlumnes);
                ObjectInputStream ois = new ObjectInputStream(fis);

                alumnes = (ArrayList<Alumne>) ois.readObject();

                ois.close();
                fis.close();
            } catch (EOFException e) {
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        Alumne alumne = new Alumne("49535056w", "Abdel", "Fatah", "it", 18);
        alumnes.add(alumne);

        try {
            FileOutputStream fos = new FileOutputStream(directoriAlumnes);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(alumnes);

            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return alumnes;
    }

    public ArrayList<Professor> createProfessor(String filePath) {
        ArrayList<Professor> professors = new ArrayList<>();
        File professorsFile = new File(filePath);

        if (professorsFile.exists()) {
            try {
                FileInputStream fis = new FileInputStream(professorsFile);
                ObjectInputStream ois = new ObjectInputStream(fis);

                professors = (ArrayList<Professor>) ois.readObject();

                ois.close();
                fis.close();
            } catch (EOFException e) {
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        Professor professor = new Professor("12345678X", "Juan", "Pérez", "juan@example.com", 40, new String[]{"Matemáticas", "Física"}, "3A");
        professors.add(professor);

        try {
            FileOutputStream fos = new FileOutputStream(professorsFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(professors);

            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return professors;
    }

    public Optional<Alumne> mirarAlumne() throws IOException, ClassNotFoundException {
        ArrayList<Alumne> alumnes = new ArrayList<>();
        File directoriAlumnes = new File("src/Files/alumnes.dat");
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

        String nif = "49535056w";

        if (alumnes.size() >= 0) {
            for (int i = 0; i < alumnes.size(); i++) {
                if (nif.equalsIgnoreCase(alumnes.get(i).getDni()) && !trobat) {
                    trobat = true;
                    indexAlumneTrobat = i;
                }
            }
        }
        Alumne alumneTrobat = null;
        if (trobat) {
            alumneTrobat = alumnes.get(indexAlumneTrobat);
        }
        return Optional.ofNullable(alumneTrobat);
    }

    public ArrayList<Professor> updateProfessor() throws IOException, ClassNotFoundException {
        String nif = "12345678X";
        ArrayList<Professor> professors = new ArrayList<>();
        ArrayList<Professor> updatedProfessors = new ArrayList<>();
        File directoriProfessors = new File("src/Files/professors.dat");
        boolean trobat = false;

        try {
            if (directoriProfessors.exists() && directoriProfessors.length() > 0) {
                FileInputStream fis = new FileInputStream(directoriProfessors);
                ObjectInputStream ois = new ObjectInputStream(fis);

                professors = (ArrayList<Professor>) ois.readObject();

                ois.close();
                fis.close();
            }
        } catch (EOFException e) {
            e.printStackTrace();
        }

        for (Professor professor : professors) {
            if (professor.getDni().equalsIgnoreCase(nif)) {
                trobat = true;
                professor.setDni("00000000T");
                professor.setNom("Manolilla");
                professor.setCognom("Dianabol");

                int numeroAssignatures = 2;
                String[] assignatures = new String[numeroAssignatures];
                assignatures[0] = "mates";
                assignatures[1] = "fisica";

                professor.setAssignatures(assignatures);
                professor.setEmail("e@e");
                professor.setEdat(30);
                professor.setCurs("it");

                updatedProfessors.add(professor);
            } else {
                updatedProfessors.add(professor);
            }
        }

        try {
            FileOutputStream fos = new FileOutputStream(directoriProfessors);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(updatedProfessors);

            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return updatedProfessors;
    }


}
