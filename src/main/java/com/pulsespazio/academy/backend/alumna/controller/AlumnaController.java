/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pulsespazio.academy.backend.alumna.controller;

import com.pulsespazio.academy.backend.alumna.dto.AlumnaRequest;
import com.pulsespazio.academy.backend.alumna.dto.AlumnaResponse;
import com.pulsespazio.academy.backend.alumna.entity.Alumna;
import com.pulsespazio.academy.backend.alumna.mapper.AlumnaMapper;
import com.pulsespazio.academy.backend.alumna.service.AlumnaService;
import java.util.List;
import lombok.RequiredArgsConstructor;
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
@RequestMapping("/api/alumnas")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class AlumnaController {

    private final AlumnaService alumnaService;

    @GetMapping
    public List<AlumnaResponse> listar() {
        return alumnaService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public AlumnaResponse obtenerPorId(@PathVariable Long id) {
        return alumnaService.obtenerPorId(id);
    }

    @PostMapping
    public AlumnaResponse guardar(@RequestBody AlumnaRequest request) {
        return alumnaService.crear(request);
    }

    @PutMapping("/{id}")
    public AlumnaResponse actualizar(@PathVariable Long id,
            @RequestBody AlumnaRequest request) {

        return alumnaService.actualizar(id, request);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        alumnaService.eliminar(id);
    }

}
