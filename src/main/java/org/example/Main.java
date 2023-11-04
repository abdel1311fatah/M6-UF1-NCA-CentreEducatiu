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
        CentreEducatiu LaSalle = new CentreEducatiu();
        //Menu d' eleccio de rol
        int rol = menu.rolMenu();
        //menu d' opcions del usuari per rol
        int option = menu.optionsMenu(rol);

        if (rol == 1 && option == 1) {

            LaSalle.mirarNotes();

        } else if (rol == 1 && option == 2) {

        } else if (rol == 1 && option == 3) {

            LaSalle.mirarProfessor();

        } else if (rol == 2 && option == 1) { // ha loguejat un profe //Abdel

            LaSalle.mirarNotes();

        } else if (rol == 2 && option == 2) { // mirar horari

        } else if (rol == 2 && option == 3) { // mirar alumne

            LaSalle.mirarAlumne();

        } else if (rol == 3 && option == 1) { // ha logejat una cuinera // Raul

        } else if (rol == 3 && option == 2) {

        } else if (rol == 4 && option == 1) { // ha logejat una secretaria //Abdel

            LaSalle.mirarAlumne();

        } else if (rol == 4 && option == 2) { // fer que no es sobreescribeixin els profes

            LaSalle.mirarProfessor();

        } else if (rol == 4 && option == 3) { // crear profes

            LaSalle.crearProfessor();

        } else if (rol == 4 && option == 4) { // actualitzar profes

            LaSalle.updateProfessor();

        } else if (rol == 4 && option == 5) { // deletejar profes

            LaSalle.deleteProfessor();

        } else if (rol == 4 && option == 6) { // crear alumnes

            LaSalle.crearAlumne();

        } else if (rol == 4 && option == 7) { // actualitzar alumne

            LaSalle.updateAlumne();

        } else if (rol == 4 && option == 8) { // Raul // borrar alumnes

            LaSalle.deleteAlumne();

        } else if (rol == 4 && option == 9) { // borrar notes

            LaSalle.deleteNota();

        } else if (rol == 4 && option == 10) { // crear notes

           LaSalle.crearNota();

        } else if (rol == 4 && option == 11) { // update notes

            LaSalle.updateNotes();

        } else if (rol == 4 && option == 12) {

            LaSalle.mirarNotes();

        }
    }
}