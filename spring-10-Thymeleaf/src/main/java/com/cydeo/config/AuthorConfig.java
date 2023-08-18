package com.cydeo.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class AuthorConfig {
    @Value("${userName}")
    private String userName;

}
