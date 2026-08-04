/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pulsespazio.academy.backend.academia.inscripcionPeriodo.service;

import com.pulsespazio.academy.backend.academia.alumna.entity.Alumna;
import com.pulsespazio.academy.backend.academia.alumna.repository.AlumnaRepository;
import com.pulsespazio.academy.backend.academia.inscripcionPeriodo.dto.InscripcionPeriodoRequest;
import com.pulsespazio.academy.backend.academia.inscripcionPeriodo.dto.InscripcionPeriodoResponse;
import com.pulsespazio.academy.backend.academia.inscripcionPeriodo.entity.InscripcionPeriodo;
import com.pulsespazio.academy.backend.academia.inscripcionPeriodo.mapper.InscripcionPeriodoMapper;
import com.pulsespazio.academy.backend.academia.inscripcionPeriodo.repository.InscripcionPeriodoRepository;
import com.pulsespazio.academy.backend.academia.periodo.entity.Periodo;
import com.pulsespazio.academy.backend.academia.periodo.repository.PeriodoRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dany
 */


@Service
@RequiredArgsConstructor
public class InscripcionPeriodoServiceImpl implements InscripcionPeriodoService {

    private final InscripcionPeriodoRepository inscripcionPeriodoRepository;
    private final AlumnaRepository alumnaRepository;
    private final PeriodoRepository periodoRepository;
    private final InscripcionPeriodoMapper mapper;

    @Override
    public List<InscripcionPeriodoResponse> obtenerTodos() {
        return inscripcionPeriodoRepository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public InscripcionPeriodoResponse obtenerPorId(Long id) {

        InscripcionPeriodo inscripcion = inscripcionPeriodoRepository
                .findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "Inscripción no encontrada"
                        ));

        return mapper.toResponse(inscripcion);
    }

    @Override
    public InscripcionPeriodoResponse crear(
            InscripcionPeriodoRequest request) {

        Alumna alumna = alumnaRepository
                .findById(request.getIdAlumna())
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "Alumna no encontrada"
                        ));

        Periodo periodo = periodoRepository
                .findById(request.getIdPeriodo())
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "Periodo no encontrado"
                        ));

        InscripcionPeriodo inscripcion =
                mapper.toEntity(request);

        inscripcion.setAlumna(alumna);
        inscripcion.setPeriodo(periodo);

        return mapper.toResponse(
                inscripcionPeriodoRepository.save(inscripcion)
        );
    }

    @Override
    public InscripcionPeriodoResponse actualizar(
            Long id,
            InscripcionPeriodoRequest request) {

        InscripcionPeriodo inscripcion =
                inscripcionPeriodoRepository.findById(id)
                        .orElseThrow(() ->
                                new EntityNotFoundException(
                                        "Inscripción no encontrada"
                                ));

        Alumna alumna = alumnaRepository
                .findById(request.getIdAlumna())
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "Alumna no encontrada"
                        ));

        Periodo periodo = periodoRepository
                .findById(request.getIdPeriodo())
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "Periodo no encontrado"
                        ));

        inscripcion.setAlumna(alumna);
        inscripcion.setPeriodo(periodo);

        return mapper.toResponse(
                inscripcionPeriodoRepository.save(inscripcion)
        );
    }

    @Override
    public void eliminar(Long id) {

        InscripcionPeriodo inscripcion =
                inscripcionPeriodoRepository.findById(id)
                        .orElseThrow(() ->
                                new EntityNotFoundException(
                                        "Inscripción no encontrada"
                                ));

        inscripcionPeriodoRepository.delete(inscripcion);
    }
}