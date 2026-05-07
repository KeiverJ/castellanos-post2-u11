package com.empresa.catalogo.factory;

import com.empresa.catalogo.dto.ProductoRequestDTO;
import com.empresa.catalogo.dto.ProductoResponseDTO;
import com.empresa.catalogo.entity.Producto;
import org.springframework.stereotype.Component;

/**
 * Factory responsable de la conversión entre Entidad y DTOs.
 * Principio SRP: centraliza toda la lógica de mapeo en un único lugar.
 */
@Component
public class ProductoFactory {

    /**
     * Convierte un DTO de entrada en una entidad Producto lista para persistir.
     *
     * @param dto datos recibidos del cliente
     * @return entidad Producto construida
     */
    public Producto toEntity(ProductoRequestDTO dto) {
        Producto p = new Producto();
        p.setNombre(dto.getNombre());
        p.setPrecio(dto.getPrecio());
        p.setCategoria(dto.getCategoria());
        return p;
    }

    /**
     * Convierte una entidad Producto en un DTO de respuesta para el cliente.
     *
     * @param p entidad recuperada de la base de datos
     * @return DTO de respuesta con los campos públicos del producto
     */
    public ProductoResponseDTO toResponseDTO(Producto p) {
        ProductoResponseDTO dto = new ProductoResponseDTO();
        dto.setId(p.getId());
        dto.setNombre(p.getNombre());
        dto.setPrecio(p.getPrecio());
        dto.setCategoria(p.getCategoria());
        return dto;
    }
}
