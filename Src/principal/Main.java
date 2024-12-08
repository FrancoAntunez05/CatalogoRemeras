package com.catalogo;

import com.catalogo.excepciones.CatalogoException;

/**
 * Clase principal que inicia el programa de gestión del catálogo de remeras.
 */
public class Main {
    public static void main(String[] args) {
        try {
            Catalogo catalogo = new Catalogo();
            Menu menu = new Menu(catalogo);
            menu.mostrarMenu();
        } catch (CatalogoException e) {
            System.out.println(" Error al iniciar el programa: " + e.getMessage());
        }
    }
}

