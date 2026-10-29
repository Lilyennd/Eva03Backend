package com.example.demo.repository;

import com.example.demo.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;
import java.util.Optional;


public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    List<Producto> findByActivoTrue();
    Optional<Producto> findByIdProductoAndActivoTrue(Integer id);
    @Query("SELECT p FROM Producto p WHERE p.activo = true AND p.stock <= p.stockCritico")
    List<Producto> findProductosCriticos();
}
