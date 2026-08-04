/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pulsespazio.academy.backend.academia.clasePeriodo.service;

import com.pulsespazio.academy.backend.academia.clasePeriodo.dto.ClasePeriodoRequest;
import com.pulsespazio.academy.backend.academia.clasePeriodo.dto.ClasePeriodoResponse;
import java.util.List;

/**
 *
 * @author Dany
 */
public interface ClasePeriodoService {
    
     List<ClasePeriodoResponse> obtenerTodos();

    ClasePeriodoResponse obtenerPorId(Long id);

    ClasePeriodoResponse crear(ClasePeriodoRequest request);

    ClasePeriodoResponse actualizar(Long id, ClasePeriodoRequest request);

    void eliminar(Long id);
    
}
