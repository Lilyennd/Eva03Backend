package com.example.demo.service;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findByActivoTrue();
    }

    public Usuario obtenerPorId(Integer id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    @Transactional
    public Usuario guardar(Usuario usuario) {
        if (usuario.getActivo() == null) usuario.setActivo(true);
        return usuarioRepository.save(usuario);
    }

    @Transactional
    public void desactivar(Integer id) {
        Usuario u = obtenerPorId(id);
        u.setActivo(false);
        usuarioRepository.save(u);
    }
}
