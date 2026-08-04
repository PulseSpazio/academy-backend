/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pulsespazio.academy.backend.academia.periodo.controller;

import com.pulsespazio.academy.backend.academia.periodo.dto.PeriodoRequest;
import com.pulsespazio.academy.backend.academia.periodo.dto.PeriodoResponse;
import com.pulsespazio.academy.backend.academia.periodo.service.PeriodoService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Dany
 */
@RestController
@RequestMapping("/api/periodos")
@CrossOrigin(origins = "*")
public class PeriodoController {

    private final PeriodoService periodoService;

    public PeriodoController(PeriodoService periodoService) {
        this.periodoService = periodoService;
    }

    @GetMapping
    public ResponseEntity<List<PeriodoResponse>> obtenerTodos() {
        return ResponseEntity.ok(periodoService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeriodoResponse> obtenerPorId(
            @PathVariable Long id) {

        return ResponseEntity.ok(periodoService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<PeriodoResponse> crear(
            @Valid @RequestBody PeriodoRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(periodoService.crear(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PeriodoResponse> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody PeriodoRequest request) {

        return ResponseEntity.ok(
                periodoService.actualizar(id, request)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(
            @PathVariable Long id) {

        periodoService.eliminar(id);

        return ResponseEntity.noContent().build();
    }
}
