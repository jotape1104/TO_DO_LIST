package com.karlos.todolist.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Configuração do CORS para permitir a origem e métodos específicos
        registry.addMapping("/**")  // Permitindo todas as rotas
                .allowedOrigins("http://localhost:3000")  // Permite a origem do front-end
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Permite os métodos necessários
                .allowedHeaders("*")  // Permite qualquer cabeçalho
                .allowCredentials(true);  // Permite credenciais, se necessário
    }
}
