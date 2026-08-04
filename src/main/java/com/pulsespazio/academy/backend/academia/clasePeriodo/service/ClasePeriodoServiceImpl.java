/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pulsespazio.academy.backend.academia.clasePeriodo.service;

import com.pulsespazio.academy.backend.academia.clasePeriodo.dto.ClasePeriodoRequest;
import com.pulsespazio.academy.backend.academia.clasePeriodo.dto.ClasePeriodoResponse;
import com.pulsespazio.academy.backend.academia.clasePeriodo.entity.ClasePeriodo;
import com.pulsespazio.academy.backend.academia.clasePeriodo.mapper.ClasePeriodoMapper;
import com.pulsespazio.academy.backend.academia.clasePeriodo.repository.ClasePeriodoRepository;
import com.pulsespazio.academy.backend.academia.clases.entity.Clase;
import com.pulsespazio.academy.backend.academia.clases.repository.ClaseRepository;
import com.pulsespazio.academy.backend.academia.periodo.entity.Periodo;
import com.pulsespazio.academy.backend.academia.periodo.repository.PeriodoRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dany
 */
@Service
public class ClasePeriodoServiceImpl implements ClasePeriodoService {

    private final ClasePeriodoRepository clasePeriodoRepository;
    private final ClaseRepository claseRepository;
    private final PeriodoRepository periodoRepository;

    public ClasePeriodoServiceImpl(
            ClasePeriodoRepository clasePeriodoRepository,
            ClaseRepository claseRepository,
            PeriodoRepository periodoRepository) {

        this.clasePeriodoRepository = clasePeriodoRepository;
        this.claseRepository = claseRepository;
        this.periodoRepository = periodoRepository;
    }

    @Override
    public List<ClasePeriodoResponse> obtenerTodos() {
        return clasePeriodoRepository.findAll()
                .stream()
                .map(ClasePeriodoMapper::toResponse)
                .toList();
    }

    @Override
    public ClasePeriodoResponse obtenerPorId(Long id) {

        ClasePeriodo clasePeriodo = clasePeriodoRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "ClasePeriodo no encontrado"));

        return ClasePeriodoMapper.toResponse(clasePeriodo);
    }

    @Override
    public ClasePeriodoResponse crear(ClasePeriodoRequest request) {

        Clase clase = claseRepository.findById(request.getIdClase())
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "Clase no encontrada"));

        Periodo periodo = periodoRepository.findById(request.getIdPeriodo())
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "Periodo no encontrado"));

        ClasePeriodo clasePeriodo = new ClasePeriodo();

        clasePeriodo.setClase(clase);
        clasePeriodo.setPeriodo(periodo);

        ClasePeriodo guardado =
                clasePeriodoRepository.save(clasePeriodo);

        return ClasePeriodoMapper.toResponse(guardado);
    }

    @Override
    public ClasePeriodoResponse actualizar(
            Long id,
            ClasePeriodoRequest request) {

        ClasePeriodo clasePeriodo =
                clasePeriodoRepository.findById(id)
                        .orElseThrow(() ->
                                new EntityNotFoundException(
                                        "ClasePeriodo no encontrado"));

        Clase clase = claseRepository.findById(request.getIdClase())
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "Clase no encontrada"));

        Periodo periodo = periodoRepository.findById(request.getIdPeriodo())
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "Periodo no encontrado"));

        clasePeriodo.setClase(clase);
        clasePeriodo.setPeriodo(periodo);

        ClasePeriodo actualizado =
                clasePeriodoRepository.save(clasePeriodo);

        return ClasePeriodoMapper.toResponse(actualizado);
    }

    @Override
    public void eliminar(Long id) {

        ClasePeriodo clasePeriodo =
                clasePeriodoRepository.findById(id)
                        .orElseThrow(() ->
                                new EntityNotFoundException(
                                        "ClasePeriodo no encontrado"));

        clasePeriodoRepository.delete(clasePeriodo);
    }
}
