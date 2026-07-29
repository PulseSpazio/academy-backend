/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pulsespazio.academy.backend.tutor.service;

/**
 *
 * @author Dany
 */
import com.pulsespazio.academy.backend.tutor.dto.TutorRequest;
import com.pulsespazio.academy.backend.tutor.dto.TutorResponse;
import java.util.List;

public interface TutorService {

    List<TutorResponse> obtenerTodos();

    TutorResponse obtenerPorId(Long idTutor);

    TutorResponse crear(TutorRequest request);

    TutorResponse actualizar(Long idTutor, TutorRequest request);

    void eliminar(Long idTutor);

}
