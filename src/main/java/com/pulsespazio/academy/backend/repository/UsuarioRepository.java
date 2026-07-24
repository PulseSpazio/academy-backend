/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pulsespazio.academy.backend.repository;

/**
 *
 * @author Dany
 */
import org.springframework.data.jpa.repository.JpaRepository;
import com.pulsespazio.academy.backend.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
