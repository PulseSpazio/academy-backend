/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pulsespazio.academy.backend.clases.service;

import com.pulsespazio.academy.backend.clases.dto.ClaseRequest;
import com.pulsespazio.academy.backend.clases.dto.ClaseResponse;
import com.pulsespazio.academy.backend.clases.entity.Clase;
import com.pulsespazio.academy.backend.clases.mapper.ClaseMapper;
import com.pulsespazio.academy.backend.clases.repository.ClaseRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dany
 */
@Service
public class ClaseServiceImpl implements ClaseService {

    private final ClaseRepository claseRepository;

    public ClaseServiceImpl(ClaseRepository claseRepository) {
        this.claseRepository = claseRepository;
    }

    @Override
    public List<ClaseResponse> obtenerTodos() {
        return claseRepository.findAll()
                .stream()
                .map(ClaseMapper::toResponse)
                .toList();
    }

    @Override
    public ClaseResponse obtenerPorId(Long id) {
        Clase clase = claseRepository.findById(id)
                .orElseThrow(()
                        -> new EntityNotFoundException("Clase no encontrada"));

        return ClaseMapper.toResponse(clase);
    }

    @Override
    public ClaseResponse crear(ClaseRequest request) {
        Clase clase = ClaseMapper.toEntity(request);

        Clase guardada = claseRepository.save(clase);

        return ClaseMapper.toResponse(guardada);
    }

    @Override
    public ClaseResponse actualizar(Long id, ClaseRequest request) {

        Clase clase = claseRepository.findById(id)
                .orElseThrow(()
                        -> new EntityNotFoundException("Clase no encontrada"));

        ClaseMapper.updateEntity(clase, request);

        Clase actualizada = claseRepository.save(clase);

        return ClaseMapper.toResponse(actualizada);
    }

    @Override
    public void eliminar(Long id) {

        Clase clase = claseRepository.findById(id)
                .orElseThrow(()
                        -> new EntityNotFoundException("Clase no encontrada"));

        clase.setActivo(Boolean.FALSE);

        claseRepository.save(clase);
        // claseRepository.delete(clase);
    }
}
