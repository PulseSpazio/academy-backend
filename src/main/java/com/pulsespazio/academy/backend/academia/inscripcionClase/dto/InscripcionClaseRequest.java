/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pulsespazio.academy.backend.academia.inscripcionClase.dto;

/**
 *
 * @author Dany
 */
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InscripcionClaseRequest {

    @NotNull
    private Long idInscripcionPeriodo;

    @NotNull
    private Long idClasePeriodo;
}
