package com.empresa.catalogo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Punto de entrada de la aplicación Catálogo de Productos.
 * @OpenAPIDefinition expone los metadatos globales de la API en Swagger UI.
 */
@OpenAPIDefinition(
        info = @Info(
                title = "API Catálogo de Productos",
                version = "1.0",
                description = "API REST para la gestión del catálogo de productos — UDES U11 Post2"
        )
)
@SpringBootApplication
public class CatalogoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatalogoApplication.class, args);
    }
}
