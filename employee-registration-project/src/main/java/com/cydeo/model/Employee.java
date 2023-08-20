package com.cydeo.model;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @NotBlank
    @Size(max = 20,min = 2)
    private String firsName;
    private String lastName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")  // Thymeleaf accepts yyyy-MM-dd, but the localDate accepts mm-MM-yyyy
    private LocalDate birthDate;
    private String email;
    private String password;
    private String address;
    private String address2;
    private String city;
    private String state;
    private String zipCode;
}
