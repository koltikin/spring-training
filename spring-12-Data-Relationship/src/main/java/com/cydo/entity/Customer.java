package com.cydo.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String address;
    private String email;
    @Column(length = 50)
    private String name;
    @Column(length = 50)
    private String surname;
    @Column(length = 50)
    private String username;

    @OneToMany(mappedBy = "customer",fetch = FetchType.LAZY)
    private List<Payment> paymentList;

    public Customer(String address, String email, String name, String surname, String username) {
        this.address = address;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.username = username;
    }
}
