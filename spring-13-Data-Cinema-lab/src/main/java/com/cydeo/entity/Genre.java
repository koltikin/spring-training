package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@Data
@AttributeOverride(name = "id",column = @Column(name = "genre_id"))
public class Genre extends BaseEntity{

    private String name;

}
