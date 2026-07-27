package com.pulsespazio.academy.backend.rol.service;

import com.pulsespazio.academy.backend.rol.entity.Rol;
import com.pulsespazio.academy.backend.exception.RecursoNoEncontradoException;
import com.pulsespazio.academy.backend.rol.repository.RolRepository;
import com.pulsespazio.academy.backend.rol.service.RolService;
import java.util.List;
import org.springframework.stereotype.Service;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Dany
 */
@Service
public class RolServiceImpl implements RolService {

    private final RolRepository rolRepository;

    public RolServiceImpl(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    @Override
    public List<Rol> listar() {
        return rolRepository.findAll();
    }

    @Override
    public Rol buscarPorId(Long id) {
        return rolRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Rol no encontrado"));
    }

}
