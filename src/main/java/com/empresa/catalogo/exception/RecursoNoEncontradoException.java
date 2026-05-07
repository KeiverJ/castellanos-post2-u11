package com.empresa.catalogo.exception;

/**
 * Excepción de dominio lanzada cuando un recurso solicitado no existe en la base de datos.
 * Extiende RuntimeException para integrarse con el mecanismo de Spring sin checked exceptions.
 */
public class RecursoNoEncontradoException extends RuntimeException {

    /**
     * @param recurso nombre del tipo de recurso (ej. "Producto")
     * @param id      identificador buscado
     */
    public RecursoNoEncontradoException(String recurso, Long id) {
        super(recurso + " con id " + id + " no encontrado.");
    }
}
