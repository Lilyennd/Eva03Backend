package com.example.demo.controller;

import com.example.demo.model.Comuna;
import com.example.demo.model.Region;
import com.example.demo.service.UbicacionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@Tag(name = "Ubicaciones", description = "Regiones y comunas de Chile")
public class UbicacionController {

    private final UbicacionService ubicacionService;

    public UbicacionController(UbicacionService ubicacionService) {
        this.ubicacionService = ubicacionService;
    }

    @GetMapping("/regiones")
    @Operation(summary = "Obtener todas las regiones")
    public ResponseEntity<List<Region>> listarRegiones() {
        return ResponseEntity.ok(ubicacionService.obtenerRegiones());
    }

    @GetMapping("/comunas")
    @Operation(summary = "Obtener comunas por ID de region")
    public ResponseEntity<List<Comuna>> listarComunas(@RequestParam Integer idRegion) {
        return ResponseEntity.ok(ubicacionService.obtenerComunasPorRegion(idRegion));
    }
}
