/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pulsespazio.academy.backend.alumna.dto;

/**
 *
 * @author Dany
 */
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlumnaResponse {

    private Long idAlumna;

    private String nombre;

    private String apellidoPaterno;

    private String apellidoMaterno;

    private LocalDate fechaNacimiento;

    private String telefono;

    private String escuela;

    private String gradoEscolar;

    private String informacionMedica;

    private Boolean activo;

    private LocalDateTime fechaAlta;

    private Long idTutor;

    private String nombreTutor;

}
