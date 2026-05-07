package com.empresa.catalogo.repository;

import com.empresa.catalogo.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * DAO (Data Access Object) — patrón Repository de Spring Data JPA.
 * Extiende JpaRepository para obtener operaciones CRUD sin código adicional.
 * Principio DIP: ProductoServiceImpl depende de esta abstracción, no de una implementación concreta.
 */
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    /**
     * Recupera todos los productos cuyo campo activo sea true.
     *
     * @return lista de productos activos
     */
    List<Producto> findByActivoTrue();
}
