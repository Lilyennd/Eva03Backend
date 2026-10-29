package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.service.BlogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs")
@CrossOrigin(origins = "*")
@Tag(name = "Blogs", description = "Gestion de articulos y publicaciones")
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping
    @Operation(summary = "Listar articulos activos")
    public ResponseEntity<List<Blog>> listar() {
        return ResponseEntity.ok(blogService.obtenerTodos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener articulo por ID con su detalle HTML")
    public ResponseEntity<Blog> obtenerPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(blogService.obtenerPorId(id));
    }

    @PostMapping
    @Operation(summary = "Crear nuevo articulo de blog")
    public ResponseEntity<Blog> crear(@RequestBody Blog blog) {
        return ResponseEntity.status(HttpStatus.CREATED).body(blogService.guardar(blog));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar articulo de blog")
    public ResponseEntity<Blog> actualizar(@PathVariable Integer id, @RequestBody Blog blog) {
        blog.setIdBlog(id);
        return ResponseEntity.ok(blogService.guardar(blog));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Desactivar articulo")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        blogService.desactivar(id);
        return ResponseEntity.noContent().build();
    }
}
