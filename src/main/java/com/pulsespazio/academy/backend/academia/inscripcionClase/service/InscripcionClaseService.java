/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pulsespazio.academy.backend.academia.inscripcionClase.service;

/**
 *
 * @author Dany
 */


import com.pulsespazio.academy.backend.academia.inscripcionClase.dto.InscripcionClaseRequest;
import com.pulsespazio.academy.backend.academia.inscripcionClase.dto.InscripcionClaseResponse;
import java.util.List;

public interface InscripcionClaseService {

    List<InscripcionClaseResponse> obtenerTodos();

    InscripcionClaseResponse obtenerPorId(Long id);

    InscripcionClaseResponse crear(InscripcionClaseRequest request);

    InscripcionClaseResponse actualizar(
            Long id,
            InscripcionClaseRequest request
    );

    void eliminar(Long id);
}
