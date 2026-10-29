package com.example.demo.service;

import com.example.demo.model.Producto;
import com.example.demo.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductoService {
    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Producto> obtenerTodos() {
        return productoRepository.findByActivoTrue();
    }

    public Producto obtenerPorId(Integer id) {
        return productoRepository.findByIdProductoAndActivoTrue(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    public List<Producto> obtenerCriticos() {
        return productoRepository.findProductosCriticos();
    }

    @Transactional
    public Producto actualizarStock(Integer id, Integer nuevoStock) {
        Producto p = obtenerPorId(id);
        p.setStock(nuevoStock);
        return productoRepository.save(p);
    }

    @Transactional
    public Producto guardar(Producto producto) {
        if (producto.getActivo() == null) producto.setActivo(true);
        if (producto.getEnOferta() == null) producto.setEnOferta(false);
        return productoRepository.save(producto);
    }

    @Transactional
    public void desactivar(Integer id) {
        Producto p = obtenerPorId(id);
        p.setActivo(false);
        productoRepository.save(p);
    }
}
