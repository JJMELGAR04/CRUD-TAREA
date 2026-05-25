package com.example.restaurante.services.impl;

import com.example.restaurante.dto.request.CreatePlatoRequest;
import com.example.restaurante.dto.request.UpdatePlatoRequest;
import com.example.restaurante.dto.response.plato.PlatoResponse;
import com.example.restaurante.exceptions.ResourceNotFoundException;
import com.example.restaurante.repositories.PlatoRepository;
import com.example.restaurante.services.PlatoService;
import com.example.restaurante.utils.PlatoMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlatoServiceImpl implements PlatoService {

    private final PlatoRepository platoRepository;
    private final PlatoMapper platoMapper;

    @Override
    @Transactional
    public PlatoResponse createPlato(CreatePlatoRequest request) {
        return platoMapper.toDto(
                platoRepository.save(platoMapper.toEntityCreate(request))
        );
    }

    @Override
    public List<PlatoResponse> getAllPlatos() {
        List<PlatoResponse> platos = platoRepository.findAll()
                .stream()
                .map(platoMapper::toDto)
                .collect(Collectors.toList());

        if (platos.isEmpty())
            throw new ResourceNotFoundException("No hay platos registrados.");

        return platos;
    }

    @Override
    public PlatoResponse getPlatoById(Long id) {
        return platoMapper.toDto(
                platoRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException(
                                "Plato no encontrado con id: " + id))
        );
    }

    @Override
    @Transactional
    public PlatoResponse updatePlato(Long id, UpdatePlatoRequest request) {
        this.getPlatoById(id);
        return platoMapper.toDto(
                platoRepository.save(platoMapper.toEntityUpdate(request, id))
        );
    }

    @Override
    @Transactional
    public PlatoResponse deletePlato(Long id) {
        PlatoResponse existing = this.getPlatoById(id);
        platoRepository.deleteById(id);
        return existing;
    }
}
