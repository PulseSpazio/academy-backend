/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pulsespazio.academy.backend.rol.controller;

import com.pulsespazio.academy.backend.rol.entity.Rol;
import com.pulsespazio.academy.backend.rol.service.RolService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Roles", description = "Operaciones relacionadas con roles")
public class RolController {

    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @GetMapping
    @Operation(
            summary = "Consulta todos los roles",
            description = "Obtiene el catálogo de roles registrados en el sistema"
    )
    public List<Rol> listar() {
        return rolService.listar();
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Consulta un rol por identificador",
            description = "Obtiene un rol específico mediante su ID"
    )
    public Rol buscarPorId(
            @Parameter(description = "ID del rol", example = "1")
            @PathVariable Long id) {

        return rolService.buscarPorId(id);
    }

}
