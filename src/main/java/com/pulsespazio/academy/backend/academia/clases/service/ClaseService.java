/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pulsespazio.academy.backend.academia.clases.service;

import com.pulsespazio.academy.backend.academia.clases.dto.ClaseRequest;
import com.pulsespazio.academy.backend.academia.clases.dto.ClaseResponse;
import java.util.List;

/**
 *
 * @author Dany
 */
public interface ClaseService {

    List<ClaseResponse> obtenerTodos();

    ClaseResponse obtenerPorId(Long id);

    ClaseResponse crear(ClaseRequest request);

    ClaseResponse actualizar(Long id, ClaseRequest request);

    void eliminar(Long id);
}
