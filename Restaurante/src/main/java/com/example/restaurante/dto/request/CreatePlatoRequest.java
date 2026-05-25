package com.example.restaurante.dto.request;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreatePlatoRequest {
    private String nombre;
    private String descripcion;
    private Double precio;
    private Boolean disponible;
}
