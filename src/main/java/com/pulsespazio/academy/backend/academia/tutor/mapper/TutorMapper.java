/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pulsespazio.academy.backend.academia.tutor.mapper;

/**
 *
 * @author Dany
 */
import com.pulsespazio.academy.backend.academia.tutor.dto.TutorRequest;
import com.pulsespazio.academy.backend.academia.tutor.dto.TutorResponse;
import com.pulsespazio.academy.backend.academia.tutor.entity.Tutor;
import org.springframework.stereotype.Component;

@Component
public class TutorMapper {

    public TutorResponse toResponse(Tutor tutor) {

        if (tutor == null) {
            return null;
        }

        TutorResponse response = new TutorResponse();

        response.setIdTutor(tutor.getIdTutor());

        response.setNombre(tutor.getNombre());
        response.setApellidoPaterno(tutor.getApellidoPaterno());
        response.setApellidoMaterno(tutor.getApellidoMaterno());

        response.setTelefono(tutor.getTelefono());
        response.setCorreo(tutor.getCorreo());

        response.setParentesco(tutor.getParentesco());

        response.setNombreEmergencia(tutor.getNombreEmergencia());
        response.setParentescoEmergencia(tutor.getParentescoEmergencia());
        response.setTelefonoEmergencia(tutor.getTelefonoEmergencia());

        response.setActivo(tutor.getActivo());

        response.setFechaCreacion(tutor.getFechaCreacion());
        response.setFechaActualizacion(tutor.getFechaActualizacion());

        return response;
    }

    public Tutor toEntity(TutorRequest request) {

        if (request == null) {
            return null;
        }

        Tutor tutor = new Tutor();

        updateEntity(request, tutor);

        return tutor;
    }

    public void updateEntity(TutorRequest request, Tutor tutor) {

        if (request == null || tutor == null) {
            return;
        }

        tutor.setNombre(request.getNombre());
        tutor.setApellidoPaterno(request.getApellidoPaterno());
        tutor.setApellidoMaterno(request.getApellidoMaterno());

        tutor.setTelefono(request.getTelefono());
        tutor.setCorreo(request.getCorreo());

        tutor.setParentesco(request.getParentesco());

        tutor.setNombreEmergencia(request.getNombreEmergencia());
        tutor.setParentescoEmergencia(request.getParentescoEmergencia());
        tutor.setTelefonoEmergencia(request.getTelefonoEmergencia());

        tutor.setActivo(request.getActivo());

    }

}
