package com.cydeo.service;

import com.cydeo.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> getUsers();

    UserDTO create(UserDTO userDTO);

    void delete(long userId);

    UserDTO findById(long userId);

    UserDTO updateUser(long userId, UserDTO userDTO);
}
