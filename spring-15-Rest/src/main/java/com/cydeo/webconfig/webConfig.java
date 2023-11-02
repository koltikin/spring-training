package com.cydeo.webconfig;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.output.MigrateResult;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class webConfig {
    @Bean
    public ModelMapper getMapper(){
        return new ModelMapper();
    }

    @Bean
    public MigrateResult migrateResult(DataSource dataSource){
        return Flyway.configure().baselineOnMigrate(true).dataSource(dataSource).load().migrate();
    }
}
