/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pulsespazio.academy.backend.academia.periodo.service;

import com.pulsespazio.academy.backend.academia.periodo.dto.PeriodoRequest;
import com.pulsespazio.academy.backend.academia.periodo.dto.PeriodoResponse;
import com.pulsespazio.academy.backend.academia.periodo.entity.Periodo;
import com.pulsespazio.academy.backend.academia.periodo.mapper.PeriodoMapper;
import com.pulsespazio.academy.backend.academia.periodo.repository.PeriodoRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dany
 */
@Service
public class PeriodoServiceImpl implements PeriodoService {

    private final PeriodoRepository periodoRepository;

    public PeriodoServiceImpl(PeriodoRepository periodoRepository) {
        this.periodoRepository = periodoRepository;
    }

    @Override
    public List<PeriodoResponse> obtenerTodos() {
        return periodoRepository.findAll()
                .stream()
                .map(PeriodoMapper::toResponse)
                .toList();
    }

    @Override
    public PeriodoResponse obtenerPorId(Long id) {
        Periodo periodo = periodoRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Periodo no encontrado"));

        return PeriodoMapper.toResponse(periodo);
    }

    @Override
    public PeriodoResponse crear(PeriodoRequest request) {
        Periodo periodo = PeriodoMapper.toEntity(request);

        Periodo guardado = periodoRepository.save(periodo);

        return PeriodoMapper.toResponse(guardado);
    }

    @Override
    public PeriodoResponse actualizar(Long id, PeriodoRequest request) {
        Periodo periodo = periodoRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Periodo no encontrado"));

        PeriodoMapper.updateEntity(periodo, request);

        Periodo actualizado = periodoRepository.save(periodo);

        return PeriodoMapper.toResponse(actualizado);
    }

    @Override
    public void eliminar(Long id) {
        Periodo periodo = periodoRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Periodo no encontrado"));

        periodo.setEstatus("F");

        periodoRepository.save(periodo);
    }
}