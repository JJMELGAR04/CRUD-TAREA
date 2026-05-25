package com.example.restaurante.dto.request;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePlatoRequest {
    private String nombre;
    private String descripcion;
    private Double precio;
    private Boolean disponible;
}
