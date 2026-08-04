/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pulsespazio.academy.backend.academia.inscripcionPeriodo.controller;

/**
 *
 * @author Dany
 */
import com.pulsespazio.academy.backend.academia.inscripcionPeriodo.dto.InscripcionPeriodoRequest;
import com.pulsespazio.academy.backend.academia.inscripcionPeriodo.dto.InscripcionPeriodoResponse;
import com.pulsespazio.academy.backend.academia.inscripcionPeriodo.service.InscripcionPeriodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inscripciones-periodo")
@RequiredArgsConstructor
public class InscripcionPeriodoController {

    private final InscripcionPeriodoService inscripcionPeriodoService;

    @GetMapping
    public ResponseEntity<List<InscripcionPeriodoResponse>> obtenerTodos() {

        return ResponseEntity.ok(
                inscripcionPeriodoService.obtenerTodos()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<InscripcionPeriodoResponse> obtenerPorId(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                inscripcionPeriodoService.obtenerPorId(id)
        );
    }

    @PostMapping
    public ResponseEntity<InscripcionPeriodoResponse> crear(
            @Valid @RequestBody InscripcionPeriodoRequest request) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(inscripcionPeriodoService.crear(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InscripcionPeriodoResponse> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody InscripcionPeriodoRequest request) {

        return ResponseEntity.ok(
                inscripcionPeriodoService.actualizar(id, request)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(
            @PathVariable Long id) {

        inscripcionPeriodoService.eliminar(id);

        return ResponseEntity.noContent().build();
    }
}
