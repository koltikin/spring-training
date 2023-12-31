package com.cydeo.dto;

import com.cydeo.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {

    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // the field not going to be sent to user but receive from user
    private String password;
    private String username;
    private UserRole role;

    @JsonManagedReference  // this field is going to be serialized
    private AccountDTO account;

}
