package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class LoginResponse {
    private Integer idUsuario;
    private String nombre;
    private String apellidos;
    private String correo;
    private Integer idRol;
    private String nombreRol;
}
