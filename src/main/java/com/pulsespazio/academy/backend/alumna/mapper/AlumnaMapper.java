/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pulsespazio.academy.backend.alumna.mapper;

import com.pulsespazio.academy.backend.alumna.dto.AlumnaRequest;
import com.pulsespazio.academy.backend.alumna.dto.AlumnaResponse;
import com.pulsespazio.academy.backend.alumna.entity.Alumna;

/**
 *
 * @author Dany
 */
public class AlumnaMapper {

    private AlumnaMapper() {
    }

    public static Alumna toEntity(AlumnaRequest request) {

        Alumna alumna = new Alumna();

        alumna.setNombre(request.getNombre());
        alumna.setApellidoPaterno(request.getApellidoPaterno());
        alumna.setApellidoMaterno(request.getApellidoMaterno());
        alumna.setFechaNacimiento(request.getFechaNacimiento());
        alumna.setTelefono(request.getTelefono());
        alumna.setEscuela(request.getEscuela());
        alumna.setGradoEscolar(request.getGradoEscolar());
        alumna.setInformacionMedica(request.getInformacionMedica());
        alumna.setActivo(request.getActivo());

        return alumna;
    }

    public static AlumnaResponse toResponse(Alumna alumna) {

        AlumnaResponse response = new AlumnaResponse();

        response.setIdAlumna(alumna.getIdAlumna());
        response.setNombre(alumna.getNombre());
        response.setApellidoPaterno(alumna.getApellidoPaterno());
        response.setApellidoMaterno(alumna.getApellidoMaterno());
        response.setFechaNacimiento(alumna.getFechaNacimiento());
        response.setTelefono(alumna.getTelefono());
        response.setEscuela(alumna.getEscuela());
        response.setGradoEscolar(alumna.getGradoEscolar());
        response.setInformacionMedica(alumna.getInformacionMedica());
        response.setActivo(alumna.getActivo());
        response.setFechaAlta(alumna.getFechaAlta());

        if (alumna.getTutor() != null) {
            response.setIdTutor(alumna.getTutor().getIdTutor());

            String nombreCompleto =
                    alumna.getTutor().getNombre() + " "
                  + alumna.getTutor().getApellidoPaterno();

            response.setNombreTutor(nombreCompleto.trim());
        }

        return response;
    }
    
    public static void updateEntity(Alumna alumna, AlumnaRequest request) {

    alumna.setNombre(request.getNombre());
    alumna.setApellidoPaterno(request.getApellidoPaterno());
    alumna.setApellidoMaterno(request.getApellidoMaterno());
    alumna.setFechaNacimiento(request.getFechaNacimiento());
    alumna.setTelefono(request.getTelefono());
    alumna.setEscuela(request.getEscuela());
    alumna.setGradoEscolar(request.getGradoEscolar());
    alumna.setInformacionMedica(request.getInformacionMedica());
    alumna.setActivo(request.getActivo());

}

}
