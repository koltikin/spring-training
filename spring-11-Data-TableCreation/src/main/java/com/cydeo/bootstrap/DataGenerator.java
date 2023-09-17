package com.cydeo.bootstrap;

import com.cydeo.Repository.CarRepository;
import com.cydeo.entity.Car;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class DataGenerator implements CommandLineRunner {

    CarRepository repository;

    @Override
    public void run(String... args) throws Exception {

        Car c1 = new Car("BMW","M3");
        Car c2 = new Car("Honda","Civic");
        Car c3 = new Car("Toyota","Corolla");

        repository.save(c1);
        repository.save(c2);
        repository.save(c3);


    }
}
