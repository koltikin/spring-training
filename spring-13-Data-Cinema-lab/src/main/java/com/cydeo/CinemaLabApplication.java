package com.cydeo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CinemaLabApplication {

	public static void main(String[] args) {
		SpringApplication.run(CinemaLabApplication.class, args);
	}
//	@Bean
//	public MigrateResult migrateResult(DataSource dataSource){
//		return Flyway.configure().baselineOnMigrate(true).dataSource(dataSource).load().migrate();
//
//	}

}
