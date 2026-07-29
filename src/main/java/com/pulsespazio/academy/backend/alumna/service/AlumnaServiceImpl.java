/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pulsespazio.academy.backend.alumna.service;

/**
 *
 * @author Dany
 */
import com.pulsespazio.academy.backend.alumna.dto.AlumnaRequest;
import com.pulsespazio.academy.backend.alumna.dto.AlumnaResponse;
import com.pulsespazio.academy.backend.alumna.entity.Alumna;
import com.pulsespazio.academy.backend.alumna.mapper.AlumnaMapper;
import com.pulsespazio.academy.backend.alumna.repository.AlumnaRepository;
import com.pulsespazio.academy.backend.tutor.entity.Tutor;
import com.pulsespazio.academy.backend.tutor.repository.TutorRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Service
@RequiredArgsConstructor
public class AlumnaServiceImpl implements AlumnaService {

    private final AlumnaRepository alumnaRepository;
    private final TutorRepository tutorRepository;

    @Override
    public List<AlumnaResponse> obtenerTodos() {
        return alumnaRepository.findAll()
                .stream()
                .map(AlumnaMapper::toResponse)
                .toList();
    }

    @Override
    public AlumnaResponse obtenerPorId(Long id) {

        Alumna alumna = alumnaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Alumna no encontrada"));

        return AlumnaMapper.toResponse(alumna);
    }

    @Override
    public void eliminar(Long id) {
        alumnaRepository.deleteById(id);
    }

    @Override
    public AlumnaResponse crear(AlumnaRequest request) {
        Alumna alumna = AlumnaMapper.toEntity(request);

        Tutor tutor = tutorRepository.findById(request.getIdTutor())
                .orElseThrow(() -> new EntityNotFoundException("Tutor no encontrado"));

        alumna.setTutor(tutor);

        alumna = alumnaRepository.save(alumna);

        return AlumnaMapper.toResponse(alumna);
    }

    @Override
    public AlumnaResponse actualizar(Long id, AlumnaRequest request) {
        Alumna alumna = alumnaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tutor no encontrado"));
        
        Tutor tutor = tutorRepository.findById(request.getIdTutor())
                .orElseThrow(() -> new EntityNotFoundException("Tutor no encontrado"));

        alumna.setTutor(tutor);

        AlumnaMapper.updateEntity(alumna, request);

        alumna = alumnaRepository.save(alumna);

        return AlumnaMapper.toResponse(alumna);
    }

}
