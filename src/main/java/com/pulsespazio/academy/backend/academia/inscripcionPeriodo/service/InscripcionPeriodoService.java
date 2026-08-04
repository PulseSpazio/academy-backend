/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pulsespazio.academy.backend.academia.inscripcionPeriodo.service;

import com.pulsespazio.academy.backend.academia.inscripcionPeriodo.dto.InscripcionPeriodoRequest;
import com.pulsespazio.academy.backend.academia.inscripcionPeriodo.dto.InscripcionPeriodoResponse;
import java.util.List;

/**
 *
 * @author Dany
 */

public interface InscripcionPeriodoService {

    List<InscripcionPeriodoResponse> obtenerTodos();

    InscripcionPeriodoResponse obtenerPorId(Long id);

    InscripcionPeriodoResponse crear(InscripcionPeriodoRequest request);

    InscripcionPeriodoResponse actualizar(
            Long id,
            InscripcionPeriodoRequest request
    );

    void eliminar(Long id);
}
