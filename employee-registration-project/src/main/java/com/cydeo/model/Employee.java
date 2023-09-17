package com.cydeo.model;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @NotBlank
    @Size(max = 20,min = 2)
    private String firstName ,lastName;

    @NotNull(message = "Birth Date is Required")
    @Past(message = "Birth date must be in the past")
    @DateTimeFormat(pattern = "yyyy-MM-dd")  // Thymeleaf accepts yyyy-MM-dd, but the localDate accepts mm-MM-yyyy
    private LocalDate birthDate;

    @Email
    private String email;
    @NotBlank
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "Password must be at least 8 characters long and contain at least one uppercase letter," +
                    " one lowercase letter, one digit, and one special character.")
    private String password;
    private String address;
    private String address2;
    private String city;
    private String state;
    private String zipCode;
}
