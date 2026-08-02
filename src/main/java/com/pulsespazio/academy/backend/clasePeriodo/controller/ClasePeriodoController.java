/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pulsespazio.academy.backend.clasePeriodo.controller;

import com.pulsespazio.academy.backend.clasePeriodo.dto.ClasePeriodoRequest;
import com.pulsespazio.academy.backend.clasePeriodo.dto.ClasePeriodoResponse;
import com.pulsespazio.academy.backend.clasePeriodo.service.ClasePeriodoService;
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
@RequestMapping("/api/clases-periodos")
@CrossOrigin(origins = "*")
public class ClasePeriodoController {

    private final ClasePeriodoService clasePeriodoService;

    public ClasePeriodoController(ClasePeriodoService clasePeriodoService) {
        this.clasePeriodoService = clasePeriodoService;
    }

    @GetMapping
    public ResponseEntity<List<ClasePeriodoResponse>> obtenerTodos() {
        return ResponseEntity.ok(
                clasePeriodoService.obtenerTodos()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClasePeriodoResponse> obtenerPorId(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                clasePeriodoService.obtenerPorId(id)
        );
    }

    @PostMapping
    public ResponseEntity<ClasePeriodoResponse> crear(
            @Valid @RequestBody ClasePeriodoRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(clasePeriodoService.crear(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClasePeriodoResponse> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody ClasePeriodoRequest request) {

        return ResponseEntity.ok(
                clasePeriodoService.actualizar(id, request)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(
            @PathVariable Long id) {

        clasePeriodoService.eliminar(id);

        return ResponseEntity.noContent().build();
    }
}
