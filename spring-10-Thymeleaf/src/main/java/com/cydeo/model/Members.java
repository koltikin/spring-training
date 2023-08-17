package com.cydeo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
abstract class Members {
    private String firstName, lastName, state;
    private int age;
}
