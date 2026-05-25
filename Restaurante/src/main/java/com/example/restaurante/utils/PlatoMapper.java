package com.example.restaurante.utils;

import com.example.restaurante.dto.request.CreatePlatoRequest;
import com.example.restaurante.dto.request.UpdatePlatoRequest;
import com.example.restaurante.dto.response.plato.PlatoResponse;
import com.example.restaurante.entities.Plato;
import org.springframework.stereotype.Component;

@Component
public class PlatoMapper {

    public Plato toEntityCreate(CreatePlatoRequest request) {
        return Plato.builder()
                .nombre(request.getNombre())
                .descripcion(request.getDescripcion())
                .precio(request.getPrecio())
                .disponible(request.getDisponible())
                .build();
    }

    public Plato toEntityUpdate(UpdatePlatoRequest request, Long id) {
        return Plato.builder()
                .id(id)
                .nombre(request.getNombre())
                .descripcion(request.getDescripcion())
                .precio(request.getPrecio())
                .disponible(request.getDisponible())
                .build();
    }

    public PlatoResponse toDto(Plato plato) {
        return PlatoResponse.builder()
                .id(plato.getId())
                .nombre(plato.getNombre())
                .descripcion(plato.getDescripcion())
                .precio(plato.getPrecio())
                .disponible(plato.getDisponible())
                .build();
    }
}
