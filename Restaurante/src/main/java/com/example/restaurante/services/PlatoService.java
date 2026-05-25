package com.example.restaurante.services;

import com.example.restaurante.dto.request.CreatePlatoRequest;
import com.example.restaurante.dto.request.UpdatePlatoRequest;
import com.example.restaurante.dto.response.plato.PlatoResponse;

import java.util.List;

public interface PlatoService {
    PlatoResponse createPlato(CreatePlatoRequest request);
    List<PlatoResponse> getAllPlatos();
    PlatoResponse getPlatoById(Long id);
    PlatoResponse updatePlato(Long id, UpdatePlatoRequest request);
    PlatoResponse deletePlato(Long id);
}
