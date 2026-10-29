package com.example.demo.repository;

import com.example.demo.model.Cupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CuponRepository extends JpaRepository<Cupon, Integer> {
    Optional<Cupon> findByCodigoAndActivoTrue(String codigo);
}
