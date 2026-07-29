/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pulsespazio.academy.backend.usuario.mapper;

import com.pulsespazio.academy.backend.usuario.dto.UsuarioRequest;
import com.pulsespazio.academy.backend.usuario.dto.UsuarioResponse;
import com.pulsespazio.academy.backend.usuario.entity.Usuario;

/**
 *
 * @author Dany
 */
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public UsuarioResponse toResponse(Usuario usuario) {

        if (usuario == null) {
            return null;
        }

        UsuarioResponse response = new UsuarioResponse();

        response.setIdUsuario(usuario.getIdUsuario());
        response.setNombre(usuario.getNombre());
        response.setApellidoPaterno(usuario.getApellidoPaterno());
        response.setApellidoMaterno(usuario.getApellidoMaterno());
        response.setCorreo(usuario.getCorreo());
        response.setActivo(usuario.getActivo());

        if (usuario.getRol() != null) {
            response.setIdRol(usuario.getRol().getIdRol());
            response.setNombreRol(usuario.getRol().getNombre());
        }

        return response;
    }

    public Usuario toEntity(UsuarioRequest request) {

        if (request == null) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setNombre(request.getNombre());
        usuario.setApellidoPaterno(request.getApellidoPaterno());
        usuario.setApellidoMaterno(request.getApellidoMaterno());
        usuario.setCorreo(request.getCorreo());
        usuario.setPassword(request.getPassword());
        usuario.setActivo(request.getActivo());

        return usuario;
    }

    public void updateEntity(UsuarioRequest request, Usuario usuario) {

        if (request == null || usuario == null) {
            return;
        }

        usuario.setNombre(request.getNombre());
        usuario.setApellidoPaterno(request.getApellidoPaterno());
        usuario.setApellidoMaterno(request.getApellidoMaterno());
        usuario.setCorreo(request.getCorreo());
        usuario.setPassword(request.getPassword());
        usuario.setActivo(request.getActivo());

    }

}
