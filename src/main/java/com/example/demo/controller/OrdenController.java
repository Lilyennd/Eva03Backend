package com.example.demo.controller;

import com.example.demo.model.Orden;
import com.example.demo.service.OrdenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordenes")
@CrossOrigin(origins = "*")
@Tag(name = "Ordenes", description = "Gestion de pedidos y compras")
public class OrdenController {

    private final OrdenService ordenService;

    public OrdenController(OrdenService ordenService) {
        this.ordenService = ordenService;
    }

    @GetMapping
    @Operation(summary = "Listar todas las ordenes")
    public ResponseEntity<List<Orden>> listar() {
        return ResponseEntity.ok(ordenService.obtenerTodas());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener orden por ID")
    public ResponseEntity<Orden> obtenerPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(ordenService.obtenerPorId(id));
    }

    @PostMapping
    @Operation(summary = "Crear nueva orden de compra")
    public ResponseEntity<Orden> crear(@RequestBody Orden orden) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ordenService.guardar(orden));
    }
}
