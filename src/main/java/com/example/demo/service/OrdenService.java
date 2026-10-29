package com.example.demo.service;

import com.example.demo.model.Orden;
import com.example.demo.repository.OrdenRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrdenService {
    private final OrdenRepository ordenRepository;

    public OrdenService(OrdenRepository ordenRepository) {
        this.ordenRepository = ordenRepository;
    }

    public List<Orden> obtenerTodas() {
        return ordenRepository.findAll();
    }

    public Orden obtenerPorId(Integer id) {
        return ordenRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Orden no encontrada"));
    }

    @Transactional
    public Orden guardar(Orden orden) {
        if (orden.getDetalles() != null) {
            orden.getDetalles().forEach(detalle -> detalle.setOrden(orden));
        }
        return ordenRepository.save(orden);
    }
}
