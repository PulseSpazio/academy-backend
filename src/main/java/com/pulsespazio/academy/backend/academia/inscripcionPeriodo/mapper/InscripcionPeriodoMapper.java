/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pulsespazio.academy.backend.academia.inscripcionPeriodo.mapper;

/**
 *
 * @author Dany
 */

import com.pulsespazio.academy.backend.academia.inscripcionPeriodo.dto.InscripcionPeriodoRequest;
import com.pulsespazio.academy.backend.academia.inscripcionPeriodo.dto.InscripcionPeriodoResponse;
import com.pulsespazio.academy.backend.academia.inscripcionPeriodo.entity.InscripcionPeriodo;
import org.springframework.stereotype.Component;

@Component
public class InscripcionPeriodoMapper {

    public InscripcionPeriodo toEntity(
            InscripcionPeriodoRequest request) {

        InscripcionPeriodo entity =
                new InscripcionPeriodo();

        return entity;
    }

    public InscripcionPeriodoResponse toResponse(
            InscripcionPeriodo entity) {

        InscripcionPeriodoResponse response =
                new InscripcionPeriodoResponse();

        response.setIdInscripcionPeriodo(
                entity.getIdInscripcionPeriodo());

        response.setIdAlumna(
                entity.getAlumna().getIdAlumna());

        response.setIdPeriodo(
                entity.getPeriodo().getIdPeriodo());

        return response;
    }
}
