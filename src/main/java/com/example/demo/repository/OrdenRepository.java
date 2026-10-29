package com.example.demo.repository;

import com.example.demo.model.Orden;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface OrdenRepository extends JpaRepository<Orden, Integer> {
    List<Orden> findByUsuarioIdUsuarioOrderByFechaOrdenDesc(Integer idUsuario);
}
