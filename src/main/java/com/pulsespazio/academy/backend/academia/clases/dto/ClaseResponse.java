/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pulsespazio.academy.backend.academia.clases.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Dany
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClaseResponse {

    private Long idClase;
    private String nombre;
    private String observacion;
    private Boolean activo;
}