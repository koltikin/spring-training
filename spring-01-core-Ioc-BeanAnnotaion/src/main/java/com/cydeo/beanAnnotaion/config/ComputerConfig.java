package com.cydeo.beanAnnotaion.config;

import com.cydeo.beanAnnotaion.casefactory.Case;
import com.cydeo.beanAnnotaion.casefactory.DellCase;
import com.cydeo.beanAnnotaion.monitorfactory.Monitor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ComputerConfig {
    @Bean
    public Case dellCase(){
        return new DellCase("220B", "Dell", "240");
    }

    @Bean
    public Case hpCase(){
        Case hpCase = new Case("220B", "Dell", "240") {
            @Override
            public void pressPowerButton() {
                System.out.println("Hp case's Power button pressed");
            }
        };
        return hpCase;
    }


}
