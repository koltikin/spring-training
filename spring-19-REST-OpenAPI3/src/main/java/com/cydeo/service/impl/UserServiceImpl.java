package com.cydeo.service.impl;

import com.cydeo.dto.UserDTO;
import com.cydeo.entity.User;
import com.cydeo.repository.UserRepository;
import com.cydeo.service.UserService;
import com.cydeo.util.MapperUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final MapperUtil mapperUtil;

    public UserServiceImpl(UserRepository userRepository, MapperUtil mapperUtil) {
        this.userRepository = userRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<UserDTO> getUsers() {
        return userRepository.findAll().stream().map(user -> mapperUtil.convert(user, new UserDTO())).collect(Collectors.toList());
    }

    @Override
    public UserDTO create(UserDTO userDTO) {
        return mapperUtil.convert(userRepository.save(mapperUtil.convert(userDTO, new User())), new UserDTO());
    }

    @Override
    public void delete(long userId) {
        userRepository.delete(userRepository.findById(userId).get());

    }

    @Override
    public UserDTO findById(long userId) {
        return mapperUtil.convert(userRepository.findById(userId), new UserDTO());
    }

    @Override
    public UserDTO updateUser(long userId, UserDTO userDTO) {
        User user = mapperUtil.convert(userDTO,new User());
        user.setId(userId);
        userRepository.save(user);
        return mapperUtil.convert(user,new UserDTO());
    }
}
