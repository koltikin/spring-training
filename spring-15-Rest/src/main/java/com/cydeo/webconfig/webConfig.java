package com.cydeo.webconfig;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class webConfig {
    @Bean
    public ModelMapper getMapper(){
        return new ModelMapper();
    }
}
