package com.example.demo.service;

import com.example.demo.model.Categoria;
import com.example.demo.repository.CategoriaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> obtenerTodas() {
        return categoriaRepository.findByActivoTrue();
    }

    public Categoria obtenerPorId(Integer id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria no encontrada"));
    }

    @Transactional
    public Categoria guardar(Categoria categoria) {
        if (categoria.getActivo() == null) categoria.setActivo(true);
        return categoriaRepository.save(categoria);
    }

    @Transactional
    public void desactivar(Integer id) {
        Categoria c = obtenerPorId(id);
        c.setActivo(false);
        categoriaRepository.save(c);
    }
}
