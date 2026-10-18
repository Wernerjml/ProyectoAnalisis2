package com.tienda.carrito.repository;

import com.tienda.carrito.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    // Spring Data JPA provee automáticamente los métodos CRUD (save, findAll, findById, delete)
}
