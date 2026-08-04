/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pulsespazio.academy.backend.academia.inscripcionPeriodo.repository;

/**
 *
 * @author Dany
 */
import com.pulsespazio.academy.backend.academia.inscripcionPeriodo.entity.InscripcionPeriodo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscripcionPeriodoRepository
        extends JpaRepository<InscripcionPeriodo, Long> {
}
