/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pulsespazio.academy.backend.academia.alumna.repository;

/**
 *
 * @author Dany
 */
import com.pulsespazio.academy.backend.academia.alumna.entity.Alumna;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AlumnaRepository extends JpaRepository<Alumna, Long> {

}
