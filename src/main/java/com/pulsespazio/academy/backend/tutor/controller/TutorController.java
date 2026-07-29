/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pulsespazio.academy.backend.tutor.controller;

import com.pulsespazio.academy.backend.tutor.dto.TutorRequest;
import com.pulsespazio.academy.backend.tutor.dto.TutorResponse;
import com.pulsespazio.academy.backend.tutor.service.TutorService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Dany
 */
@RestController
@RequestMapping("/api/tutores")
@CrossOrigin(origins = "*")
public class TutorController {

    private final TutorService tutorService;

    public TutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    @GetMapping
    public List<TutorResponse> obtenerTodos() {
        return tutorService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public TutorResponse obtenerPorId(@PathVariable Long id) {
        return tutorService.obtenerPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TutorResponse crear(@RequestBody TutorRequest request) {
        return tutorService.crear(request);
    }

    @PutMapping("/{id}")
    public TutorResponse actualizar(@PathVariable Long id,
            @RequestBody TutorRequest request) {
        return tutorService.actualizar(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        tutorService.eliminar(id);
    }

}
