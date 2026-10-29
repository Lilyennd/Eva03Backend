package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "blog_detalle")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BlogDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_blog")
    private Integer idDetalleBlog;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_blog", nullable = false)
    @JsonIgnore
    private Blog blog;

    @Column(name = "descripcion_larga", nullable = false, columnDefinition = "TEXT")
    private String descripcionLarga;
}
