package com.example.demo.controller;

import com.example.demo.model.Producto;
import com.example.demo.service.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/productos")
@CrossOrigin(origins = "*")
@Tag(name = "Productos", description = "Gestion del catalogo de gemas y productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    @Operation(summary = "Listar todos los productos activos")
    public ResponseEntity<List<Producto>> listar() {
        return ResponseEntity.ok(productoService.obtenerTodos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener producto por ID")
    public ResponseEntity<Producto> obtenerPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(productoService.obtenerPorId(id));
    }

    @GetMapping("/criticos")
    @Operation(summary = "Obtener productos con stock critico")
    public ResponseEntity<List<Producto>> listarCriticos() {
        return ResponseEntity.ok(productoService.obtenerCriticos());
    }

    @PatchMapping("/{id}/stock")
    @Operation(summary = "Actualizar el stock de un producto")
    public ResponseEntity<Producto> actualizarStock(@PathVariable Integer id, @RequestBody Map<String, Integer> payload) {
        Integer nuevoStock = payload.get("stock");
        return ResponseEntity.ok(productoService.actualizarStock(id, nuevoStock));
    }

    @PostMapping
    @Operation(summary = "Crear nuevo producto")
    public ResponseEntity<Producto> crear(@RequestBody Producto producto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productoService.guardar(producto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un producto existente")
    public ResponseEntity<Producto> actualizar(@PathVariable Integer id, @RequestBody Producto producto) {
        producto.setIdProducto(id);
        return ResponseEntity.ok(productoService.guardar(producto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminacion logica de un producto")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        productoService.desactivar(id);
        return ResponseEntity.noContent().build();
    }
}
