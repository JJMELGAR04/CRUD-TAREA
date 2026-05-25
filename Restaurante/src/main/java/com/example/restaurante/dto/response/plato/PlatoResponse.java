package com.example.restaurante.dto.response.plato;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlatoResponse {
    private Long id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Boolean disponible;
}
