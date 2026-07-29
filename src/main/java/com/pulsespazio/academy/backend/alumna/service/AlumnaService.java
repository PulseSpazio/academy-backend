/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pulsespazio.academy.backend.alumna.service;

import com.pulsespazio.academy.backend.alumna.dto.AlumnaRequest;
import com.pulsespazio.academy.backend.alumna.dto.AlumnaResponse;
import java.util.List;

/**
 *
 * @author Dany
 */
public interface AlumnaService {

    List<AlumnaResponse> obtenerTodos();

    AlumnaResponse obtenerPorId(Long id);

    AlumnaResponse crear(AlumnaRequest request);

    AlumnaResponse actualizar(Long id, AlumnaRequest request);

    void eliminar(Long id);
}
