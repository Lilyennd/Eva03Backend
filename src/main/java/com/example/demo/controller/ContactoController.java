package com.example.demo.controller;

import com.example.demo.model.Contacto;
import com.example.demo.service.ContactoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacto")
@CrossOrigin(origins = "*")
@Tag(name = "Contacto", description = "Recepcion y lectura de mensajes de clientes")
public class ContactoController {

    private final ContactoService contactoService;

    public ContactoController(ContactoService contactoService) {
        this.contactoService = contactoService;
    }

    @GetMapping
    @Operation(summary = "Listar mensajes de contacto")
    public ResponseEntity<List<Contacto>> listar() {
        return ResponseEntity.ok(contactoService.obtenerTodos());
    }

    @PostMapping
    @Operation(summary = "Enviar mensaje de contacto")
    public ResponseEntity<Contacto> crear(@RequestBody Contacto contacto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(contactoService.guardar(contacto));
    }
}
