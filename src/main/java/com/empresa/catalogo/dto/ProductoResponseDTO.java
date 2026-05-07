package com.empresa.catalogo.dto;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * DTO de salida: datos expuestos por la API hacia el cliente.
 * No expone campos sensibles ni internos de la entidad (SRP de presentación).
 */
@Schema(description = "Datos del producto retornados por la API")
public class ProductoResponseDTO {

    @Schema(description = "Identificador único del producto", example = "1")
    private Long id;

    @Schema(description = "Nombre del producto", example = "Laptop HP ProBook")
    private String nombre;

    @Schema(description = "Precio en pesos colombianos", example = "3500000.00")
    private Double precio;

    @Schema(description = "Categoría del producto", example = "ELECTRONICA")
    private String categoria;

    // ── Getters y Setters ────────────────────────────────────────────────────

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
}
