package com.example.restaurante.controllers;

import com.example.restaurante.dto.request.CreatePlatoRequest;
import com.example.restaurante.dto.request.UpdatePlatoRequest;
import com.example.restaurante.dto.response.GeneralResponse;
import com.example.restaurante.services.PlatoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/platos")
@RequiredArgsConstructor
public class PlatoController {

    private final PlatoService platoService;

    public ResponseEntity<GeneralResponse> buildResponse(
            String message, HttpStatus status, Object data) {

        String uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri().build().getPath();

        return ResponseEntity
                .status(status)
                .body(GeneralResponse.builder()
                        .uri(uri)
                        .message(message)
                        .status(status.value())
                        .time(LocalDateTime.now())
                        .data(data)
                        .build()
                );
    }

    @PostMapping("/create")
    public ResponseEntity<GeneralResponse> createPlato(
            @RequestBody CreatePlatoRequest request) {
        return buildResponse(
                "Plato creado exitosamente.",
                HttpStatus.CREATED,
                platoService.createPlato(request)
        );
    }

    @GetMapping("/getAll")
    public ResponseEntity<GeneralResponse> getAllPlatos() {
        return buildResponse(
                "Platos obtenidos exitosamente.",
                HttpStatus.OK,
                platoService.getAllPlatos()
        );
    }

    @GetMapping("/getBy/{id}")
    public ResponseEntity<GeneralResponse> getPlatoById(@PathVariable Long id) {
        return buildResponse(
                "Plato encontrado.",
                HttpStatus.OK,
                platoService.getPlatoById(id)
        );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<GeneralResponse> updatePlato(
            @PathVariable Long id,
            @RequestBody UpdatePlatoRequest request) {
        return buildResponse(
                "Plato actualizado exitosamente.",
                HttpStatus.OK,
                platoService.updatePlato(id, request)
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<GeneralResponse> deletePlato(@PathVariable Long id) {
        return buildResponse(
                "Plato eliminado exitosamente.",
                HttpStatus.OK,
                platoService.deletePlato(id)
        );
    }
}
