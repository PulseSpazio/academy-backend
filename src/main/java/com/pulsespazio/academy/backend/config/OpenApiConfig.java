/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pulsespazio.academy.backend.config;

/**
 *
 * @author Dany
 */

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI pulseSpazioOpenAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("PulseSpazio Academy API")
                        .description("API para la administración de academias PulseSpazio.")
                        .version("1.0.0")
                        .contact(new Contact().name("PulseSpazio")))
                .externalDocs(new ExternalDocumentation()
                        .description("Documentación del proyecto"));

    }

}
