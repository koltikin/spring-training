package com.cydeo.model;

import lombok.AllArgsConstructor;
import lombok.Data;


public class Student extends Members{

    public Student(String firstName, String lastName, String state, int age) {
        super(firstName, lastName, state, age);
    }
}
