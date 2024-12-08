package com.catalogo;

import java.io.Serializable;

/**
 * La clase Remera representa una remera de fútbol con atributos de equipo, talle y precio.
 */
public class Remera implements Serializable {
    private int id;
    private String equipo;
    private String talle;
    private double precio;

    public Remera(int id, String equipo, String talle, double precio) {
        this.id = id;
        this.equipo = equipo;
        this.talle = talle;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getTalle() {
        return talle;
    }

    public void setTalle(String talle) {
        this.talle = talle;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Equipo: %s | Talle: %s | Precio: $%.2f",
                id, equipo, talle, precio);
    }
}
