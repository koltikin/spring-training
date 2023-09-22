package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AttributeOverride(name = "id",column = @Column(name = "cinema_id"))
public class Cinema extends BaseEntity{
    private String name;
    private String sponsoredName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private Location location;
}
