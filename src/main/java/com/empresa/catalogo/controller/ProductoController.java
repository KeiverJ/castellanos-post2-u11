package com.empresa.catalogo.controller;

import com.empresa.catalogo.dto.ProductoRequestDTO;
import com.empresa.catalogo.dto.ProductoResponseDTO;
import com.empresa.catalogo.exception.ApiError;
import com.empresa.catalogo.service.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST del catálogo de productos.
 * Principio DIP: depende de la interfaz ProductoService, no de su implementación.
 * Principio SRP: solo maneja el mapeo HTTP → servicio; no contiene lógica de negocio.
 */
@RestController
@RequestMapping("/api/productos")
@Tag(name = "Productos", description = "Operaciones CRUD del catálogo de productos")
public class ProductoController {

    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    /**
     * GET /api/productos
     * Lista todos los productos activos.
     */
    @Operation(summary = "Listar todos los productos activos")
    @ApiResponse(responseCode = "200", description = "Lista de productos retornada exitosamente",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ProductoResponseDTO.class)))
    @GetMapping
    public ResponseEntity<List<ProductoResponseDTO>> listar() {
        return ResponseEntity.ok(service.listarActivos());
    }

    /**
     * GET /api/productos/{id}
     * Recupera un producto por id. Retorna 404 si no existe.
     */
    @Operation(summary = "Obtener producto por ID")
    @ApiResponse(responseCode = "200", description = "Producto encontrado",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ProductoResponseDTO.class)))
    @ApiResponse(responseCode = "404", description = "Producto no encontrado",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ApiError.class)))
    @GetMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> buscar(
            @Parameter(description = "ID del producto a consultar", example = "1")
            @PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    /**
     * POST /api/productos
     * Crea un producto con los datos validados del body.
     * Retorna 201 Created con el DTO de respuesta incluyendo el id generado.
     */
    @Operation(summary = "Crear un nuevo producto")
    @ApiResponse(responseCode = "201", description = "Producto creado exitosamente",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ProductoResponseDTO.class)))
    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ApiError.class)))
    @PostMapping
    public ResponseEntity<ProductoResponseDTO> crear(
            @Valid @RequestBody ProductoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.crear(dto));
    }

    /**
     * DELETE /api/productos/{id}
     * Elimina un producto por id. Retorna 204 No Content si tiene éxito.
     */
    @Operation(summary = "Eliminar producto por ID")
    @ApiResponse(responseCode = "204", description = "Producto eliminado correctamente")
    @ApiResponse(responseCode = "404", description = "Producto no encontrado",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ApiError.class)))
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(
            @Parameter(description = "ID del producto a eliminar", example = "1")
            @PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
