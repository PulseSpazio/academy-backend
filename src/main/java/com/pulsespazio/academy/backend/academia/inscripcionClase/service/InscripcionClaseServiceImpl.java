/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pulsespazio.academy.backend.academia.inscripcionClase.service;

/**
 *
 * @author Dany
 */
import com.pulsespazio.academy.backend.academia.clasePeriodo.entity.ClasePeriodo;
import com.pulsespazio.academy.backend.academia.clasePeriodo.repository.ClasePeriodoRepository;
import com.pulsespazio.academy.backend.academia.inscripcionClase.dto.InscripcionClaseRequest;
import com.pulsespazio.academy.backend.academia.inscripcionClase.dto.InscripcionClaseResponse;
import com.pulsespazio.academy.backend.academia.inscripcionClase.entity.InscripcionClase;
import com.pulsespazio.academy.backend.academia.inscripcionClase.mapper.InscripcionClaseMapper;
import com.pulsespazio.academy.backend.academia.inscripcionClase.repository.InscripcionClaseRepository;
import com.pulsespazio.academy.backend.academia.inscripcionPeriodo.entity.InscripcionPeriodo;
import com.pulsespazio.academy.backend.academia.inscripcionPeriodo.repository.InscripcionPeriodoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InscripcionClaseServiceImpl
        implements InscripcionClaseService {

    private final InscripcionClaseRepository inscripcionClaseRepository;
    private final InscripcionPeriodoRepository inscripcionPeriodoRepository;
    private final ClasePeriodoRepository clasePeriodoRepository;
    private final InscripcionClaseMapper mapper;

    @Override
    public List<InscripcionClaseResponse> obtenerTodos() {

        return inscripcionClaseRepository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public InscripcionClaseResponse obtenerPorId(Long id) {

        InscripcionClase inscripcion
                = inscripcionClaseRepository.findById(id)
                        .orElseThrow(()
                                -> new EntityNotFoundException(
                                "Inscripción a clase no encontrada"
                        ));

        return mapper.toResponse(inscripcion);
    }

    @Override
    public InscripcionClaseResponse crear(
            InscripcionClaseRequest request) {

        InscripcionPeriodo inscripcionPeriodo
                = inscripcionPeriodoRepository
                        .findById(request.getIdInscripcionPeriodo())
                        .orElseThrow(()
                                -> new EntityNotFoundException(
                                "Inscripción al periodo no encontrada"
                        ));

        ClasePeriodo clasePeriodo
                = clasePeriodoRepository
                        .findById(request.getIdClasePeriodo())
                        .orElseThrow(()
                                -> new EntityNotFoundException(
                                "Clase del periodo no encontrada"
                        ));

        InscripcionClase inscripcion
                = mapper.toEntity(request);

        inscripcion.setInscripcionPeriodo(
                inscripcionPeriodo);

        inscripcion.setClasePeriodo(
                clasePeriodo);

        return mapper.toResponse(
                inscripcionClaseRepository.save(inscripcion)
        );
    }

    @Override
    public InscripcionClaseResponse actualizar(
            Long id,
            InscripcionClaseRequest request) {

        InscripcionClase inscripcion
                = inscripcionClaseRepository.findById(id)
                        .orElseThrow(()
                                -> new EntityNotFoundException(
                                "Inscripción a clase no encontrada"
                        ));

        InscripcionPeriodo inscripcionPeriodo
                = inscripcionPeriodoRepository
                        .findById(request.getIdInscripcionPeriodo())
                        .orElseThrow(()
                                -> new EntityNotFoundException(
                                "Inscripción al periodo no encontrada"
                        ));

        ClasePeriodo clasePeriodo
                = clasePeriodoRepository
                        .findById(request.getIdClasePeriodo())
                        .orElseThrow(()
                                -> new EntityNotFoundException(
                                "Clase del periodo no encontrada"
                        ));

        inscripcion.setInscripcionPeriodo(
                inscripcionPeriodo);

        inscripcion.setClasePeriodo(
                clasePeriodo);

        return mapper.toResponse(
                inscripcionClaseRepository.save(inscripcion)
        );
    }

    @Override
    public void eliminar(Long id) {

        InscripcionClase inscripcion
                = inscripcionClaseRepository.findById(id)
                        .orElseThrow(()
                                -> new EntityNotFoundException(
                                "Inscripción a clase no encontrada"
                        ));

        inscripcionClaseRepository.delete(inscripcion);
    }
}
