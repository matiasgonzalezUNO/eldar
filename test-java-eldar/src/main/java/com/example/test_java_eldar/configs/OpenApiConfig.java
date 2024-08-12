package com.example.test_java_eldar.configs;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Eldar test",
                version = "1.0.0",
                description = "this is doc of endpoint"
        )
)
public class OpenApiConfig {
}
