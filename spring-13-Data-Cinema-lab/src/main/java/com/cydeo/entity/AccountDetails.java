package com.cydeo.entity;

import com.cydeo.enums.UserRole;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
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

    @Override
    public String toString() {
        return "AccountDetails{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", age=" + age +
                ", postalCode='" + postalCode + '\'' +
                ", role=" + role +
                "} " + super.toString();
    }
}
