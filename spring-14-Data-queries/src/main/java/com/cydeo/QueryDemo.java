package com.cydeo;

import com.cydeo.repository.RegionRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class QueryDemo implements CommandLineRunner {
    private final RegionRepository regionRepository;
    @Override
    public void run(String... args) throws Exception {
        System.out.println("findByCountry: " + regionRepository.findByCountry("Canada"));
        System.out.println("getCountryContains: " + regionRepository.getByCountryContains("United"));

    }
}
