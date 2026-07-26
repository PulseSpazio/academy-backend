/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pulsespazio.academy.backend.service;

import com.pulsespazio.academy.backend.entity.Rol;
import java.util.List;

/**
 *
 * @author Dany
 */
public interface RolService {

    List<Rol> listar();

    Rol buscarPorId(Long id);

}
