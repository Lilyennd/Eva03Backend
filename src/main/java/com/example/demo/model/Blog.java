package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "blogs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_blog")
    private Integer idBlog;

    @Column(nullable = false, unique = true, length = 200)
    private String titulo;

    @Column(name = "descripcion_corta", length = 500)
    private String descripcionCorta;

    private String imagen;

    @Column(nullable = false)
    private Boolean activo;

    @Column(name = "fecha_publicacion", insertable = false, updatable = false)
    private LocalDateTime fechaPublicacion;

    @OneToOne(mappedBy = "blog", cascade = CascadeType.ALL, orphanRemoval = true)
    private BlogDetalle detalle;
}
