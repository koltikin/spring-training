package com.cydeo.config;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI getOpenApi(){
        return new OpenAPI().info(new Info()
                .title("Cydeo Application OpenApi")
                .version("v2")
                .description("Cydeo Application Open Api documentation"))
                .servers(List.of(new Server().url("http://localhost:8080")
                        .description("local server"), new Server().url("https://dev.cydeo.com")
                        .description("dev environment")));
    }

}
