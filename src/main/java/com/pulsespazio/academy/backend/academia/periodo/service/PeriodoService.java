/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pulsespazio.academy.backend.academia.periodo.service;

import com.pulsespazio.academy.backend.academia.periodo.dto.PeriodoRequest;
import com.pulsespazio.academy.backend.academia.periodo.dto.PeriodoResponse;
import java.util.List;

/**
 *
 * @author Dany
 */
public interface PeriodoService {

    List<PeriodoResponse> obtenerTodos();

    PeriodoResponse obtenerPorId(Long id);

    PeriodoResponse crear(PeriodoRequest request);

    PeriodoResponse actualizar(Long id, PeriodoRequest request);

    void eliminar(Long id);
}
