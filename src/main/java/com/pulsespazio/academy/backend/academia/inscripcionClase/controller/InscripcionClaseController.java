/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pulsespazio.academy.backend.academia.inscripcionClase.controller;

/**
 *
 * @author Dany
 */
import com.pulsespazio.academy.backend.academia.inscripcionClase.dto.InscripcionClaseRequest;
import com.pulsespazio.academy.backend.academia.inscripcionClase.dto.InscripcionClaseResponse;
import com.pulsespazio.academy.backend.academia.inscripcionClase.service.InscripcionClaseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inscripciones-clase")
@RequiredArgsConstructor
public class InscripcionClaseController {

    private final InscripcionClaseService inscripcionClaseService;

    @GetMapping
    public ResponseEntity<List<InscripcionClaseResponse>> obtenerTodos() {

        return ResponseEntity.ok(
                inscripcionClaseService.obtenerTodos()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<InscripcionClaseResponse> obtenerPorId(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                inscripcionClaseService.obtenerPorId(id)
        );
    }

    @PostMapping
    public ResponseEntity<InscripcionClaseResponse> crear(
            @Valid @RequestBody InscripcionClaseRequest request) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(inscripcionClaseService.crear(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InscripcionClaseResponse> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody InscripcionClaseRequest request) {

        return ResponseEntity.ok(
                inscripcionClaseService.actualizar(id, request)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(
            @PathVariable Long id) {

        inscripcionClaseService.eliminar(id);

        return ResponseEntity.noContent().build();
    }
}
