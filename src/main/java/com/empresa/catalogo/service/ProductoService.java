package com.empresa.catalogo.service;

import com.empresa.catalogo.dto.ProductoRequestDTO;
import com.empresa.catalogo.dto.ProductoResponseDTO;

import java.util.List;

/**
 * Interfaz del servicio de productos.
 * Principio DIP: ProductoController depende de esta abstracción, nunca de ProductoServiceImpl.
 * Principio SRP: define únicamente operaciones de negocio relacionadas con productos.
 */
public interface ProductoService {

    /**
     * Crea y persiste un nuevo producto a partir del DTO de entrada.
     *
     * @param dto datos del producto a crear
     * @return DTO de respuesta con el id generado
     */
    ProductoResponseDTO crear(ProductoRequestDTO dto);

    /**
     * Recupera un producto por su identificador.
     *
     * @param id identificador del producto
     * @return DTO de respuesta del producto encontrado
     * @throws com.empresa.catalogo.exception.RecursoNoEncontradoException si no existe
     */
    ProductoResponseDTO buscarPorId(Long id);

    /**
     * Lista todos los productos cuyo estado activo sea true.
     *
     * @return lista de DTOs de productos activos
     */
    List<ProductoResponseDTO> listarActivos();

    /**
     * Elimina un producto por su identificador.
     *
     * @param id identificador del producto a eliminar
     * @throws com.empresa.catalogo.exception.RecursoNoEncontradoException si no existe
     */
    void eliminar(Long id);
}
