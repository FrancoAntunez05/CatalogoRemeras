package com.catalogo;

import com.catalogo.excepciones.CatalogoException;
import java.util.ArrayList;
import java.io.*;

/**
 * La clase Catalogo gestiona una lista de remeras de fútbol.
 */
public class Catalogo implements Serializable {
    private ArrayList<Remera> listaRemeras;
    private static final String FILE_NAME = "src/resources/catalogo.dat";

    public Catalogo() throws CatalogoException {
        leer();
    }

    public void addRemera(Remera remera) throws CatalogoException {
        try {
            listaRemeras.add(remera);
            escribir();
        } catch (Exception e) {
            throw new CatalogoException("Error al añadir la remera", e);
        }
    }

    public boolean eliminarRemera(int id) throws CatalogoException {
        try {
            Remera remeraEliminar = buscarRemeraPorId(id);
            if (remeraEliminar != null) {
                listaRemeras.remove(remeraEliminar);
                escribir();
                return true;
            }
        } catch (Exception e) {
            throw new CatalogoException("Error al eliminar la remera", e);
        }
        return false;
    }

    public Remera buscarRemeraPorId(int id) throws CatalogoException {
        try {
            for (Remera remera : listaRemeras) {
                if (remera.getId() == id) {
                    return remera;
                }
            }
        } catch (Exception e) {
            throw new CatalogoException("Error al buscar la remera por ID", e);
        }
        return null;
    }

    public void listarRemeras() throws CatalogoException {
        try {
            System.out.printf("%-4s | %-20s | %-6s | %-8s \n",
                    "ID", "Equipo", "Talle", "Precio");
            System.out.println("---------------------------------------------");
            for (Remera remera : listaRemeras) {
                System.out.printf("%-4d | %-20s | %-6s | $%-8.2f\n",
                        remera.getId(),
                        remera.getEquipo(),
                        remera.getTalle(),
                        remera.getPrecio());
            }
        } catch (Exception e) {
            throw new CatalogoException("Error al listar las remeras", e);
        }
    }

    public void escribir() throws CatalogoException {
        try (ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oo.writeObject(listaRemeras);
        } catch (IOException e) {
            throw new CatalogoException("Error al guardar los datos en el fichero", e);
        }
    }

    public void leer() throws CatalogoException {
        try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            listaRemeras = (ArrayList<Remera>) oi.readObject();
        } catch (IOException | ClassNotFoundException e) {
            listaRemeras = new ArrayList<>();
        }
    }
}
