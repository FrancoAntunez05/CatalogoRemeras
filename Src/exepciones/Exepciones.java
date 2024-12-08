package com.catalogo.excepciones;

/**
 * Excepción personalizada para errores relacionados con el catálogo de remeras.
 */
public class CatalogoException extends Exception {
    public CatalogoException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
