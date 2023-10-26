package org.example;

import org.example.Empleats.Professor;
import org.example.Menu.Menu;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        //Menu d' eleccio de rol
        int rol = menu.rolMenu();
        //menu d' opcions del usuari i creem el hashmap que te el rol de l usuari i la opcio que vol fer
        HashMap<Integer, Integer> hashmap = menu.optionsMenu(rol);

       // aqui va agafar les variables del hashmap i fer el programa

    }
}