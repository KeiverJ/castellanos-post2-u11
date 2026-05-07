package com.empresa.catalogo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

/**
 * DTO de entrada: datos enviados por el cliente hacia la API.
 * Aplica validaciones Bean Validation y anotaciones @Schema para Swagger UI.
 */
@Schema(description = "Datos requeridos para crear un producto")
public class ProductoRequestDTO {

    @Schema(description = "Nombre del producto", example = "Laptop HP ProBook")
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @Schema(description = "Precio en pesos colombianos", example = "3500000.00")
    @Positive(message = "El precio debe ser mayor a cero")
    private Double precio;

    @Schema(
            description = "Categoría del producto",
            allowableValues = {"ELECTRONICA", "PAPELERIA", "HOGAR"},
            example = "ELECTRONICA"
    )
    private String categoria;

    // ── Getters y Setters ────────────────────────────────────────────────────

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
}
