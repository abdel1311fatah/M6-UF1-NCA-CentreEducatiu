package org.example.Menu;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menu {
    public int rolMenu() {
        Scanner scan = new Scanner(System.in);
        int option = 0;
        boolean entrar = false;

        System.out.println("Introdueix el teu rol: ");
        System.out.println("0: Exit ");
        System.out.println("1: Alumne ");
        System.out.println("2: Professor: ");
        System.out.println("3: Cuinera ");
        System.out.println("4: Secretaria ");

        outer:
        do {
            System.out.println("Enter an option: ");
            option = scan.nextInt();
            if (option != 0) {


                if (option > 0 && option <= 4) {
                    entrar = true;
                } else if (option == 0) {
                    System.out.println("Has sortit correctament");
                    entrar = false;
                    break outer;
                } else {
                    System.out.println("Ha de ser un numero entre 0 i 4 ");
                }
            } else {
                System.out.println("Introdueix numeros ");
                scan.next();
            }
        } while (!entrar);

        return option;
    }

    public int optionsMenu(int option) {

        Scanner scan = new Scanner(System.in);
        boolean entrar = false;
        int order = 0;

        if (option != 0) {
            do {
                if (option == 1) { // ha loguejat un alumne
                    System.out.println("Que vols fer? ");
                    System.out.println("0: Exit ");
                    System.out.println("1: Mirar les teves notes "); // fer lo mateix que als horaris
                    System.out.println("2: Mirar horari "); // fer fitxers tipo horari1 horari2 horariIT i filtrar per cursos
                    System.out.println("3: Mirar professors "); // filtrar profes per string del curs i recorrer amb un foreach el arraylist
                    System.out.println("4: Mirar tasques ");
                    order = scan.nextInt(); // lo que vol fer l usuari una vegada ha entrat com a el rol que li toqui
                    if (order != 0 || (order > 0 && order <= 4)) {
                        return order;
                    }
                } else if (option == 2) { // ha loguejat un profe
                    System.out.println("Que vols fer? ");
                    System.out.println("0: Exit ");
                    System.out.println("1: Mirar notes"); // fer lo mateix que als horaris
                    System.out.println("2: Mirar horari "); // fer fitxers tipo horari1 horari2 horariIT i filtrar per cursos
                    System.out.println("3: Mirar alumnes "); // filtrar alumnes per string del curs i recorrer amb un foreach el arraylist
                    System.out.println("4: Mirar tasques ");
                    order = scan.nextInt(); // lo que vol fer l usuari una vegada ha entrat com a el rol que li toqui
                    if (order != 0 || (order > 0 && order <= 4)) {
                        return order;
                    }
                } else if (option == 3) { // ha loguejat una cuinera
                    System.out.println("Que vols fer? ");
                    System.out.println("0: Exit ");
                    System.out.println("1: Mirar plats de la setmana "); // foreach d un arraylist de files dels plats
                    order = scan.nextInt(); // lo que vol fer l usuari una vegada ha entrat com a el rol que li toqui
                    if (order != 0 || (order > 0 && order <= 2)) {
                        return order;
                    }
                } else if (option == 4) { // ha loguejat una secretaria

                    System.out.println("Que vols fer? "); // crud alumnes y profesors per separat
                    System.out.println("0: Exit ");
                    System.out.println("1: Mirar alumnes ");
                    System.out.println("2: Mirar profesors");
                    System.out.println("3: Insertar profesors");
                    System.out.println("4: Actualitzar profesors");
                    System.out.println("5: Borrar profesors");
                    System.out.println("6: Insertar alumnes");
                    System.out.println("7: Actualitzar alumnes");
                    System.out.println("8: Borrar alumnes");
                    System.out.println("9: Borrar notes");
                    System.out.println("10: Insertar notes");
                    System.out.println("11: Actualitzar notes");
                    System.out.println("12: Veure notes");
                    order = scan.nextInt(); // lo que vol fer l usuari una vegada ha entrat com a el rol que li toqui
                    if (order != 0 || (order > 0 && order <= 12)) {
                        return order;
                    }

                } else if (option == 0) {
                    System.out.println("Has sortit del programa");
                } else {
                    System.out.println("Introdueix numeros");
                }
            } while (order != 0);
        }
        return order;
    }

    public String email() {

        Scanner scan = new Scanner(System.in);
        System.out.println("email: ");

        String email = "";
        boolean valid = true;

        do {

            email = scan.nextLine();
            String patro = "^(.+)@(.+)$";
            Pattern pattern = Pattern.compile(patro);
            Matcher matcher = pattern.matcher(email);
            if (!email.isBlank()) {
                if (matcher.matches()) {
                    email = email.replaceAll("\\s", "");
                    valid = true;
                } else {
                    valid = false;
                    System.out.println("You have not entered a valid email, please enter a valid one: ");
                }
            } else {
                System.out.println("The email has a whitespace, please try again: ");
                valid = false;
            }

        } while (!valid);

        return email;
    }

    public String nif() {

        Scanner scan = new Scanner(System.in);
        String nif = "";
        boolean valid = false;
        outer:
        do {

            System.out.println("NIF: ");
            nif = scan.nextLine();
            String numnif = "";

            if (nif.length() == 9) {

                for (int i = 0; i <= 7; i++) {
                    numnif += nif.charAt(i);
                    if (!Character.isDigit(nif.charAt(i))) {

                        valid = false;
                        System.out.println("This nif is not correct, " + nif.charAt(i) + " is not a number");
                        continue outer;

                    }
                }

                if (Character.isAlphabetic(nif.charAt(8))) {
                    valid = true;
                } else {
                    valid = false;
                    System.out.println("Last character of the nif is not a letter");
                }
            } else {
                System.out.println("This nif does not have 9 characters");
            }

            // Validación del DNI
            if (valid) {

                char lletraDNI = nif.charAt(8);

                int numDNI = Integer.parseInt(numnif);
                String DNI = "";
                String[] lletresMaj = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
                String[] lletresMin = {"t", "r", "w", "a", "g", "m", "y", "f", "p", "d", "x", "b", "n", "j", "z", "s", "q", "v", "h", "l", "c", "k", "e"};

                int modDNI = numDNI % 23;
                if (Character.isUpperCase(lletraDNI)) {
                    DNI += lletresMaj[modDNI];
                } else if (Character.isLowerCase(lletraDNI)) {
                    DNI += lletresMin[modDNI];
                }
                if (lletraDNI == DNI.charAt(0)) {
                    valid = true;
                    nif = numnif + DNI;
                } else {
                    System.out.println("This nif is not well calculated, please try another nif: ");
                    valid = false;
                }

            } else {
                System.out.println("This nif is not valid, try again: ");
            }
        } while (!valid);

        return nif;
    }

    public String name() {

        Scanner scan = new Scanner(System.in);
        String name = "", validatedName = "";
        boolean valid = false;
        int counter = 0;

        System.out.println("Name: ");

        do {
            validatedName = scan.nextLine();

            for (char c : validatedName.toCharArray()) {

                if (Character.isLetter(c) || c == ' ') {
                    name += c;
                    valid = true;
                } else {
                    System.out.println(c + " is not a valid character for a name ");
                    valid = false;
                }
            }

            if ((!valid) && (counter > 0) || name.isBlank()) {
                System.out.println("That was an incorrect name, write a valid name: ");
                validatedName = "";
                name = "";
                valid = false;
            }
            counter++;
        } while (!valid);

        return name;
    }

    public String surname() {

        Scanner scan = new Scanner(System.in);
        String validatedSurname = "";
        String surname = "";
        boolean valid = false;
        int counter = 0;

        System.out.println("Surname: ");

        do {
            String input = scan.nextLine();

            for (char c : input.toCharArray()) {
                if (Character.isLetter(c) || c == ' ') {
                    surname += c;
                    valid = true;
                } else {
                    System.out.println(c + " is not a valid character for a surname ");
                    valid = false;
                }
            }
            if ((!valid) && (counter > 0) || surname.isBlank()) {
                System.out.println("That was an incorrect surname, write a valid surname: ");
                validatedSurname = "";
                surname = "";
                valid = false;
            }
            counter++;
        } while (!valid);

        return surname;
    }

    public String curs() {

        Scanner scan = new Scanner(System.in);
        String[] cursos = {"1", "2", "3", "4", "IT", "DAM", "ARI", "ADE", "VDS", "ES", "IEA"};
        boolean valid = false;

        System.out.println("Curs: 1, 2, 3, 4, IT, DAM, ARI, ADE, VDS, ES, IEA");
        String curs = scan.nextLine();

        do {
            for (int i = 0; i < cursos.length; i++) {
                if (cursos[i].equalsIgnoreCase(curs)) {
                    return curs;
                }
            }

            if(!valid){
                System.out.println("No has introduit un curs valid, introdueixne un valid: ");
                curs = scan.nextLine();
            }
        } while (!valid);

        return curs;
    }

    public int age() {
        Scanner scan = new Scanner(System.in);
        boolean valid = false;
        int age = obtindreInt("Age: ");

        while (!valid) {
            if (age != 0 && age > 0 && age <= 130) {
                valid = true;
            }else{
                System.out.println("No es una edat valida, introdueixne un altre: ");
                age = scan.nextInt();
            }
        }

        return age;
    }

    public String NIFtoErase() {

        Scanner scan = new Scanner(System.in);
        System.out.println("NIF of the customer you want to erase: ");
        String NIF = nif();

        return NIF;
    }

    public String NIFtoUpdate() {

        Scanner scan = new Scanner(System.in);
        System.out.println("NIF of the customer you want to update: ");
        String NIF = nif();

        return NIF;
    }

    public String NIFtoFind() {
        System.out.println("NIF of the customer you want to find: ");
        String NIFtoFind = nif();
        return NIFtoFind;
    }

    public String emailToFind() {
        System.out.println("Enter the customer's email you want to find: ");
        String email = email();
        return email;
    }

    public String nameToFind() {
        System.out.println("Enter the customer's name you want to find: ");
        String name = name();
        return name;
    }

    public String surnameToFind() {
        System.out.println("Enter the customer's surname you want to find: ");
        String surname = surname();
        return surname;
    }

    public Menu() {
    }

    public int obtindreInt(String text) {

        boolean TipusCorrecte;
        Scanner sc = new Scanner(System.in);
        int num_usuari = 0;

        do {
            System.out.print(text);
            TipusCorrecte = sc.hasNextInt();
            if (!TipusCorrecte) {
                sc.nextLine();
                System.out.println("Error: Valor no válido");
            } else {
                num_usuari = sc.nextInt();
            }
        } while (!TipusCorrecte);

        return num_usuari;
    }

    public String obtindreString(String text) {
        Scanner sc = new Scanner(System.in);

        System.out.print(text);
        String text_usuari = sc.nextLine();

        return text_usuari;
    }

}
