/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pulsespazio.academy.backend.academia.clasePeriodo.mapper;

import com.pulsespazio.academy.backend.academia.clasePeriodo.dto.ClasePeriodoResponse;
import com.pulsespazio.academy.backend.academia.clasePeriodo.entity.ClasePeriodo;

/**
 *
 * @author Dany
 */
public class ClasePeriodoMapper {

    private ClasePeriodoMapper() {
        // Utility class
    }

    public static ClasePeriodoResponse toResponse(ClasePeriodo clasePeriodo) {

        return new ClasePeriodoResponse(
                clasePeriodo.getIdClasePeriodo(),
                clasePeriodo.getClase().getIdClase(),
                clasePeriodo.getClase().getNombre(),
                clasePeriodo.getPeriodo().getIdPeriodo(),
                clasePeriodo.getPeriodo().getNombre()
        );
    }
}
