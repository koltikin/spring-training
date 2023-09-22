package com.cydeo.entity;

import com.cydeo.enums.UserRole;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "account_details_id"))
public class AccountDetails extends BaseEntity{

    private String name;
    private String address;
    private String country;
    private String city;
    private String state;
    private int age;
    private String postalCode;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @OneToOne(mappedBy = "accountDetails")
    private UserAccount userAccount;
}
