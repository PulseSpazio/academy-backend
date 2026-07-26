/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pulsespazio.academy.backend.controller;

import com.pulsespazio.academy.backend.entity.Rol;
import com.pulsespazio.academy.backend.service.RolService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Dany
 */
@RestController
@RequestMapping("/api/roles")
public class RolController {

    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @GetMapping
    public List<Rol> listar() {
        return rolService.listar();
    }

    @GetMapping("/{id}")
    public Rol buscarPorId(@PathVariable Long id) {
        return rolService.buscarPorId(id);
    }

}
