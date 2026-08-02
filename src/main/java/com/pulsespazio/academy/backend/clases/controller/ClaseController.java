/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pulsespazio.academy.backend.clases.controller;

import com.pulsespazio.academy.backend.clases.dto.ClaseRequest;
import com.pulsespazio.academy.backend.clases.dto.ClaseResponse;
import com.pulsespazio.academy.backend.clases.service.ClaseService;
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
@RequestMapping("/api/clases")
@CrossOrigin(origins = "*")
public class ClaseController {

    private final ClaseService claseService;

    public ClaseController(ClaseService claseService) {
        this.claseService = claseService;
    }

    @GetMapping
    public ResponseEntity<List<ClaseResponse>> obtenerTodos() {
        return ResponseEntity.ok(claseService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClaseResponse> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(claseService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<ClaseResponse> crear(
            @Valid @RequestBody ClaseRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(claseService.crear(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClaseResponse> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody ClaseRequest request) {

        return ResponseEntity.ok(
                claseService.actualizar(id, request)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        claseService.eliminar(id);

        return ResponseEntity.noContent().build();
    }
}
