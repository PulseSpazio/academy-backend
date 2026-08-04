/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pulsespazio.academy.backend.academia.clases.mapper;

import com.pulsespazio.academy.backend.academia.clases.dto.ClaseRequest;
import com.pulsespazio.academy.backend.academia.clases.dto.ClaseResponse;
import com.pulsespazio.academy.backend.academia.clases.entity.Clase;

/**
 *
 * @author Dany
 */
public class ClaseMapper {

    private ClaseMapper() {
     }

    public static ClaseResponse toResponse(Clase clase) {
        return new ClaseResponse(
                clase.getIdClase(),
                clase.getNombre(),
                clase.getObservacion(),
                clase.getActivo()
        );
    }

    public static Clase toEntity(ClaseRequest request) {
        Clase clase = new Clase();
        clase.setNombre(request.getNombre());
        clase.setObservacion(request.getObservacion());
        clase.setActivo(request.getActivo());
        return clase;
    }

    public static void updateEntity(Clase clase, ClaseRequest request) {
        clase.setNombre(request.getNombre());
        clase.setObservacion(request.getObservacion());
        clase.setActivo(request.getActivo());
    }
}