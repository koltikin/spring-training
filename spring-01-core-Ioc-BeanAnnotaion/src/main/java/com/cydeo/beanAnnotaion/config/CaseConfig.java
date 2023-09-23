package com.cydeo.beanAnnotaion.config;

import com.cydeo.beanAnnotaion.casefactory.AppleCase;
import com.cydeo.beanAnnotaion.casefactory.Case;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CaseConfig {

    @Bean
    public Case appleCase(){
        return  new AppleCase("2023", "apple", "240");

    }
}
