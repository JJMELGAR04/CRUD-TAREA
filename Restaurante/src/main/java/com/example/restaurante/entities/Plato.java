package com.example.restaurante.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "plato")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Plato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precio")
    private Double precio;

    @Column(name = "disponible")
    private Boolean disponible;
}