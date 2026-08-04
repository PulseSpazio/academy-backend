/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pulsespazio.academy.backend.academia.usuario.service;

import com.pulsespazio.academy.backend.academia.usuario.dto.UsuarioRequest;
import com.pulsespazio.academy.backend.academia.usuario.dto.UsuarioResponse;
import java.util.List;

/**
 *
 * @author Dany
 */
public interface UsuarioService {

    List<UsuarioResponse> obtenerTodos();

    UsuarioResponse obtenerPorId(Long id);

    UsuarioResponse guardar(UsuarioRequest request);

    UsuarioResponse actualizar(Long id,
            UsuarioRequest request);

    void eliminar(Long id);

}
