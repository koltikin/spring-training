package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "user_account_id"))
public class UserAccount extends BaseEntity{

    private String email;
    private String password;
    private String userName;

    @OneToOne
    @JoinColumn(name = "account_details_id")
    private AccountDetails accountDetails;
}
