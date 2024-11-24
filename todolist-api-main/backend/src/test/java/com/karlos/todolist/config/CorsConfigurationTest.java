package com.karlos.todolist.config;

import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static org.junit.jupiter.api.Assertions.*;

class CorsConfigurationTest {

    @Test
    void testCorsConfigurationImplementation() {
        // Instancia a configuração
        CorsConfiguration corsConfig = new CorsConfiguration();

        // Verifica se implementa WebMvcConfigurer
        assertTrue(corsConfig instanceof WebMvcConfigurer, "CorsConfiguration deve implementar WebMvcConfigurer");

        // Simula o registro de CORS
        try {
            corsConfig.addCorsMappings(new org.springframework.web.servlet.config.annotation.CorsRegistry());
        } catch (Exception e) {
            fail("A configuração CORS não deve lançar exceções: " + e.getMessage());
        }
    }
}
