package com.cydeo;

import com.cydeo.bootstrap.DataGenerator;
import com.cydeo.config.AuthorConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ThymeleafApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(ThymeleafApplication.class, args);
		DataGenerator dataGenerator = context.getBean(DataGenerator.class);
		dataGenerator.createStudent();

	}

}
