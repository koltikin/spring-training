package com.cydeo.entity;

import com.cydeo.entity.enums.Gender;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "Students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "studentFirstName")
    private String firstName;
    @Column(name = "studentLastName")
    private String lastName;
    @Column(name = "studentEmail")
    private String email;

    @Column(columnDefinition = "DATE")
    private LocalDate birthDate;
    @Column(columnDefinition = "TIME")
    private LocalTime brithTime;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime birthDateTime;

    @Enumerated(EnumType.STRING)
//    @Enumerated(EnumType.ORDINAL)
    private Gender gender;

    @Transient
    private String city;

}
