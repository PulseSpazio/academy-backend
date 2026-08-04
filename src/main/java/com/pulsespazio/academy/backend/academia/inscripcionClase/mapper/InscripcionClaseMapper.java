/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pulsespazio.academy.backend.academia.inscripcionClase.mapper;

/**
 *
 * @author Dany
 */

import com.pulsespazio.academy.backend.academia.inscripcionClase.dto.InscripcionClaseRequest;
import com.pulsespazio.academy.backend.academia.inscripcionClase.dto.InscripcionClaseResponse;
import com.pulsespazio.academy.backend.academia.inscripcionClase.entity.InscripcionClase;
import org.springframework.stereotype.Component;

@Component
public class InscripcionClaseMapper {

    public InscripcionClase toEntity(
            InscripcionClaseRequest request) {

        return new InscripcionClase();
    }

    public InscripcionClaseResponse toResponse(
            InscripcionClase entity) {

        InscripcionClaseResponse response =
                new InscripcionClaseResponse();

        response.setIdInscripcionClase(
                entity.getIdInscripcionClase());

        response.setIdInscripcionPeriodo(
                entity.getInscripcionPeriodo()
                        .getIdInscripcionPeriodo());

        response.setIdClasePeriodo(
                entity.getClasePeriodo()
                        .getIdClasePeriodo());

        return response;
    }
}
