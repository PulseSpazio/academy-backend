/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pulsespazio.academy.backend.usuario.service;

import com.pulsespazio.academy.backend.rol.entity.Rol;
import com.pulsespazio.academy.backend.rol.repository.RolRepository;
import com.pulsespazio.academy.backend.usuario.dto.UsuarioRequest;
import com.pulsespazio.academy.backend.usuario.dto.UsuarioResponse;
import com.pulsespazio.academy.backend.usuario.entity.Usuario;
import com.pulsespazio.academy.backend.usuario.mapper.UsuarioMapper;
import com.pulsespazio.academy.backend.usuario.repository.UsuarioRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dany
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;
    private final UsuarioMapper usuarioMapper;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository,
            RolRepository rolRepository,
            UsuarioMapper usuarioMapper) {

        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public List<UsuarioResponse> obtenerTodos() {

        return usuarioRepository.findAll()
                .stream()
                .map(usuarioMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioResponse obtenerPorId(Long id) {

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        return usuarioMapper.toResponse(usuario);
    }

    @Override
    public UsuarioResponse guardar(UsuarioRequest request) {

        if (usuarioRepository.existsByCorreo(request.getCorreo())) {
            throw new RuntimeException("El correo ya existe");
        }

        Rol rol = rolRepository.findById(request.getIdRol())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        Usuario usuario = usuarioMapper.toEntity(request);

        usuario.setRol(rol);

        usuario = usuarioRepository.save(usuario);

        return usuarioMapper.toResponse(usuario);
    }

    @Override
    public UsuarioResponse actualizar(Long id, UsuarioRequest request) {

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

//        Rol rol = rolRepository.findById(request.getIdRol())
//                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        usuarioMapper.updateEntity(request, usuario);

        usuario = usuarioRepository.save(usuario);

        return usuarioMapper.toResponse(usuario);
    }

    @Override
    public void eliminar(Long id) {

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        usuario.setActivo(false);

        usuarioRepository.save(usuario);
    }

}
