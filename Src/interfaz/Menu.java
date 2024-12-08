package com.catalogo;

import com.catalogo.excepciones.CatalogoException;
import java.util.Scanner;

/**
 * Clase que maneja el menú interactivo para gestionar el catálogo de remeras de fútbol.
 */
public class Menu {
    private Catalogo catalogo;
    private Scanner scanner;

    public Menu(Catalogo catalogo) {
        this.catalogo = catalogo;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Muestra el menú principal y maneja las opciones del usuario.
     */
    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n===== Gestor de Catálogo de Remeras de Fútbol =====");
            System.out.println("1. Agregar Remera");
            System.out.println("2. Mostrar Remeras");
            System.out.println("3. Eliminar Remera");
            System.out.println("4. Modificar Remera");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            try {
                switch (opcion) {
                    case 1:
                        agregarRemera();
                        break;
                    case 2:
                        catalogo.listarRemeras();
                        break;
                    case 3:
                        eliminarRemera();
                        break;
                    case 4:
                        modificarRemera();
                        break;
                    case 5:
                        System.out.println(" Saliendo del programa...");
                        break;
                    default:
                        System.out.println(" Opción no válida. Por favor, intente de nuevo.");
                }
            } catch (CatalogoException e) {
                System.out.println(" Error: " + e.getMessage());
            }

        } while (opcion != 5);
    }

    private void agregarRemera() throws CatalogoException {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Equipo: ");
        String equipo = scanner.nextLine();
        System.out.print("Talle: ");
        String talle = scanner.nextLine();
        System.out.print("Precio: ");
        double precio = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer

        catalogo.addRemera(new Remera(id, equipo, talle, precio));
        System.out.println(" Remera agregada con éxito.");
    }

    private void eliminarRemera() throws CatalogoException {
        System.out.print("ID de la remera a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        if (catalogo.eliminarRemera(id)) {
            System.out.println(" Remera eliminada con éxito.");
        } else {
            System.out.println(" Remera no encontrada.");
        }
    }

    private void modificarRemera() throws CatalogoException {
        System.out.print("ID de la remera a modificar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Nuevo equipo: ");
        String nuevoEquipo = scanner.nextLine();
        System.out.print("Nuevo talle: ");
        String nuevoTalle = scanner.nextLine();
        System.out.print("Nuevo precio: ");
        double nuevoPrecio = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer

        if (catalogo.eliminarRemera(id)) {
            catalogo.addRemera(new Remera(id, nuevoEquipo, nuevoTalle, nuevoPrecio));
            System.out.println(" Remera modificada con éxito.");
        } else {
            System.out.println(" Remera no encontrada.");
        }
    }
}

