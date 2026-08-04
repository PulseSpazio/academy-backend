/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pulsespazio.academy.backend.academia.tutor.dto;

/**
 *
 * @author Dany
 */
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TutorResponse {

    private Long idTutor;

    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;

    private String telefono;
    private String correo;

    private String parentesco;

    private String nombreEmergencia;
    private String parentescoEmergencia;
    private String telefonoEmergencia;

    private Boolean activo;

    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;

}