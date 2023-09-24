package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "COURSES")
@NoArgsConstructor
@Data
public class Course extends BaseEntity{

    @Column(name = "NAME")
    private String name;
    @Column(name = "CATEGORY")
    private String category;
    @Column(name = "RATING")
    private String rating;
    @Column(name = "DESCRIPTION")
    private String description;
}
