/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pulsespazio.academy.backend.exception;

/**
 *
 * @author Dany
 */
import java.time.LocalDateTime;

public class ErrorResponse {

    private final LocalDateTime fecha;
    private final int codigo;
    private final String mensaje;
    private final String ruta;

    public ErrorResponse(LocalDateTime fecha, int codigo, String mensaje, String ruta) {
        this.fecha = fecha;
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.ruta = ruta;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getRuta() {
        return ruta;
    }

}
