/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pulsespazio.academy.backend.academia.tutor.service;

/**
 *
 * @author Dany
 */
import com.pulsespazio.academy.backend.academia.tutor.dto.TutorRequest;
import com.pulsespazio.academy.backend.academia.tutor.dto.TutorResponse;
import com.pulsespazio.academy.backend.academia.tutor.entity.Tutor;
import com.pulsespazio.academy.backend.academia.tutor.mapper.TutorMapper;
import com.pulsespazio.academy.backend.academia.tutor.repository.TutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TutorServiceImpl implements TutorService {

    private final TutorRepository tutorRepository;
    private final TutorMapper tutorMapper;

    @Override
    public List<TutorResponse> obtenerTodos() {

        return tutorRepository.findAll()
                .stream()
                .map(tutorMapper::toResponse)
                .toList();
    }

    @Override
    public TutorResponse obtenerPorId(Long idTutor) {

        Tutor tutor = tutorRepository.findById(idTutor)
                .orElseThrow(() -> new RuntimeException("Tutor no encontrado"));

        return tutorMapper.toResponse(tutor);
    }

    @Override
    public TutorResponse crear(TutorRequest request) {

        Tutor tutor = tutorMapper.toEntity(request);

        tutor = tutorRepository.save(tutor);

        return tutorMapper.toResponse(tutor);
    }

    @Override
    public TutorResponse actualizar(Long idTutor, TutorRequest request) {

        Tutor tutor = tutorRepository.findById(idTutor)
                .orElseThrow(() -> new RuntimeException("Tutor no encontrado"));

        tutorMapper.updateEntity(request, tutor);

        tutor = tutorRepository.save(tutor);

        return tutorMapper.toResponse(tutor);
    }

    @Override
    public void eliminar(Long idTutor) {

        Tutor tutor = tutorRepository.findById(idTutor)
                .orElseThrow(() -> new RuntimeException("Tutor no encontrado"));

        tutorRepository.delete(tutor);

    }

}