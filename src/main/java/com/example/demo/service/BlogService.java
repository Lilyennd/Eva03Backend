package com.example.demo.service;

import com.example.demo.model.Blog;
import com.example.demo.repository.BlogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BlogService {
    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public List<Blog> obtenerTodos() {
        return blogRepository.findByActivoTrue();
    }

    public Blog obtenerPorId(Integer id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Blog no encontrado"));
    }

    @Transactional
    public Blog guardar(Blog blog) {
        if (blog.getActivo() == null) blog.setActivo(true);
        if (blog.getDetalle() != null) blog.getDetalle().setBlog(blog);
        return blogRepository.save(blog);
    }

    @Transactional
    public void desactivar(Integer id) {
        Blog b = obtenerPorId(id);
        b.setActivo(false);
        blogRepository.save(b);
    }
}
