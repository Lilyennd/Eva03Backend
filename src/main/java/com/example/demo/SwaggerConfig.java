package com.example.demo;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Splendor API REST")
                        .version("1.0.0")
                        .description("Documentacion de los endpoints REST migrados a Spring Boot")
                        .contact(new Contact()
                                .name("Soporte Splendor")
                                .email("admin@profesor.duoc.cl")));
    }
}
