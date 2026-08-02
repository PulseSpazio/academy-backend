/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pulsespazio.academy.backend.periodo.mapper;

import com.pulsespazio.academy.backend.periodo.dto.PeriodoRequest;
import com.pulsespazio.academy.backend.periodo.dto.PeriodoResponse;
import com.pulsespazio.academy.backend.periodo.entity.Periodo;

/**
 *
 * @author Dany
 */
public class PeriodoMapper {

    private PeriodoMapper() {

    }

    public static PeriodoResponse toResponse(Periodo periodo) {
        return new PeriodoResponse(
                periodo.getIdPeriodo(),
                periodo.getNombre(),
                periodo.getFechaInicio(),
                periodo.getFechaFin(),
                periodo.getEstatus()
        );
    }

    public static Periodo toEntity(PeriodoRequest request) {
        Periodo periodo = new Periodo();

        periodo.setNombre(request.getNombre());
        periodo.setFechaInicio(request.getFechaInicio());
        periodo.setFechaFin(request.getFechaFin());
        periodo.setEstatus(request.getEstatus());

        return periodo;
    }

    public static void updateEntity(Periodo periodo, PeriodoRequest request) {
        periodo.setNombre(request.getNombre());
        periodo.setFechaInicio(request.getFechaInicio());
        periodo.setFechaFin(request.getFechaFin());
        periodo.setEstatus(request.getEstatus());
    }
}
