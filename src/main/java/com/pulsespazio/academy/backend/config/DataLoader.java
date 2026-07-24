/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pulsespazio.academy.backend.config;

import com.pulsespazio.academy.backend.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Dany
 */
@Configuration
public class DataLoader {
    
    @Bean
CommandLineRunner prueba(UsuarioRepository usuarioRepository){

    return args -> {

        usuarioRepository.findAll()
            .forEach(usuario -> 
                System.out.println(usuario.getNombre())
            );

    };
}
    
}
