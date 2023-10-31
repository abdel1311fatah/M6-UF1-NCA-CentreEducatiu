package org.example;

import org.example.Alumnes.Alumne;
import org.example.Menu.Menu;

import java.io.File;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        //Menu d' eleccio de rol
        int rol = menu.rolMenu();
        //menu d' opcions del usuari i creem el hashmap que te el rol de l usuari i la opcio que vol fer
        int option = menu.optionsMenu(rol);

        if(rol ==  1 && option == 1){ // ha loguejat un alumne // Raul

        } else if (rol ==  1 && option == 2) {

        } else if (rol ==  1 && option == 3) {

        } else if (rol ==  1 && option == 4) {

        } else if (rol ==  2 && option == 1) { // ha loguejat un profe //Abdel

        } else if (rol ==  2 && option == 2) {

        } else if (rol ==  2 && option == 3) {

        } else if (rol ==  2 && option == 4) {

        } else if (rol ==  3 && option == 1) { // ha logejat una cuinera // Raul

        } else if (rol ==  3 && option == 2) {

        } else if (rol ==  4 && option == 1) { // ha logejat una secretaria //Abdel

        } else if (rol ==  4 && option == 2) {

        } else if (rol ==  4 && option == 3) {

        } else if (rol ==  4 && option == 4) {

        } else if (rol ==  4 && option == 5) {

        } else if (rol ==  4 && option == 6) {

        } else if (rol ==  4 && option == 7) {

        } else if (rol ==  4 && option == 8) { // Raul

        } else if (rol ==  4 && option == 9) {

        } else if (rol ==  4 && option == 10) {

        } else if (rol ==  4 && option == 11) {

        } else if (rol ==  4 && option == 12) {

        } else if (rol ==  4 && option == 13) {

        } else {
            System.out.println("No s ha pogut entrar");
        }
    }
}