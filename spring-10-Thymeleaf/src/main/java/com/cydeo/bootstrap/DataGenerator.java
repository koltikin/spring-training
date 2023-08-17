package com.cydeo.bootstrap;

import com.cydeo.model.Mentor;
import com.cydeo.model.Student;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataGenerator {
    private final Faker faker = new Faker();
    public static List<Student> STUDENTS = new ArrayList<>();
    public static List<Mentor> MENTORS = new ArrayList<>();

    public void createStudent(){

        STUDENTS = Arrays.asList(
                new Student(faker.name().firstName(),faker.name().lastName(),faker.address().state(),faker.number().numberBetween(18,50)),
                new Student(faker.name().firstName(),faker.name().lastName(),faker.address().state(),faker.number().numberBetween(18,50)),
                new Student(faker.name().firstName(),faker.name().lastName(),faker.address().state(),faker.number().numberBetween(18,50)),
                new Student(faker.name().firstName(),faker.name().lastName(),faker.address().state(),faker.number().numberBetween(18,50)),
                new Student(faker.name().firstName(),faker.name().lastName(),faker.address().state(),faker.number().numberBetween(18,50)),
                new Student(faker.name().firstName(),faker.name().lastName(),faker.address().state(),faker.number().numberBetween(18,50)),
                new Student(faker.name().firstName(),faker.name().lastName(),faker.address().state(),faker.number().numberBetween(18,50)),
                new Student(faker.name().firstName(),faker.name().lastName(),faker.address().state(),faker.number().numberBetween(18,50)),
                new Student(faker.name().firstName(),faker.name().lastName(),faker.address().state(),faker.number().numberBetween(18,50)),
                new Student(faker.name().firstName(),faker.name().lastName(),faker.address().state(),faker.number().numberBetween(18,50)),
                new Student(faker.name().firstName(),faker.name().lastName(),faker.address().state(),faker.number().numberBetween(18,50)),
                new Student(faker.name().firstName(),faker.name().lastName(),faker.address().state(),faker.number().numberBetween(18,50)),
                new Student(faker.name().firstName(),faker.name().lastName(),faker.address().state(),faker.number().numberBetween(18,50)),
                new Student(faker.name().firstName(),faker.name().lastName(),faker.address().state(),faker.number().numberBetween(18,50)),
                new Student(faker.name().firstName(),faker.name().lastName(),faker.address().state(),faker.number().numberBetween(18,50)),
                new Student(faker.name().firstName(),faker.name().lastName(),faker.address().state(),faker.number().numberBetween(18,50)),
                new Student(faker.name().firstName(),faker.name().lastName(),faker.address().state(),faker.number().numberBetween(18,50)));

        MENTORS = Arrays.asList(
                new Mentor(faker.name().firstName(),faker.name().lastName(),faker.address().state(),faker.number().numberBetween(18,50)),
                new Mentor(faker.name().firstName(),faker.name().lastName(),faker.address().state(),faker.number().numberBetween(18,50)),
                new Mentor(faker.name().firstName(),faker.name().lastName(),faker.address().state(),faker.number().numberBetween(18,50)),
                new Mentor(faker.name().firstName(),faker.name().lastName(),faker.address().state(),faker.number().numberBetween(18,50)),
                new Mentor(faker.name().firstName(),faker.name().lastName(),faker.address().state(),faker.number().numberBetween(18,50)),
                new Mentor(faker.name().firstName(),faker.name().lastName(),faker.address().state(),faker.number().numberBetween(18,50)),
                new Mentor(faker.name().firstName(),faker.name().lastName(),faker.address().state(),faker.number().numberBetween(18,50)),
                new Mentor(faker.name().firstName(),faker.name().lastName(),faker.address().state(),faker.number().numberBetween(18,50)),
                new Mentor(faker.name().firstName(),faker.name().lastName(),faker.address().state(),faker.number().numberBetween(18,50)),
                new Mentor(faker.name().firstName(),faker.name().lastName(),faker.address().state(),faker.number().numberBetween(18,50)),
                new Mentor(faker.name().firstName(),faker.name().lastName(),faker.address().state(),faker.number().numberBetween(18,50)),
                new Mentor(faker.name().firstName(),faker.name().lastName(),faker.address().state(),faker.number().numberBetween(18,50)),
                new Mentor(faker.name().firstName(),faker.name().lastName(),faker.address().state(),faker.number().numberBetween(18,50)),
                new Mentor(faker.name().firstName(),faker.name().lastName(),faker.address().state(),faker.number().numberBetween(18,50)),
                new Mentor(faker.name().firstName(),faker.name().lastName(),faker.address().state(),faker.number().numberBetween(18,50)),
                new Mentor(faker.name().firstName(),faker.name().lastName(),faker.address().state(),faker.number().numberBetween(18,50)),
                new Mentor(faker.name().firstName(),faker.name().lastName(),faker.address().state(),faker.number().numberBetween(18,50)));




    }
}
