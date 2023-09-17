package com.cydeo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import static com.cydeo.bootstrap.DataGenerator.initializeData;

@SpringBootApplication
public class EmployeeRegistrationApp {

    public static void main(String[] args) {

        SpringApplication.run(EmployeeRegistrationApp.class, args);
        initializeData();
    }

}
