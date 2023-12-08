package com.cydeo.service.impl;

import com.cydeo.mapper.UserMapper;
import com.cydeo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    @Mock
    UserRepository userRepository;

    @Mock
    UserMapper userMapper;

    @InjectMocks
    UserServiceImpl userService;

    @Test
    void findByUserName_Test(){
        userService.findByUserName("harold@manager.com");

        verify(userRepository).findByUserNameAndIsDeleted("harold@manager.com",false);

        verify(userRepository,times(1)).findByUserNameAndIsDeleted("harold@manager.com",false);
        verify(userRepository,atLeast(1)).findByUserNameAndIsDeleted("harold@manager.com",false);
        verify(userRepository,atLeastOnce()).findByUserNameAndIsDeleted("harold@manager.com",false);
        verify(userRepository,atMost(10)).findByUserNameAndIsDeleted("harold@manager.com",false);

        InOrder inOrder = inOrder(userRepository,userMapper);
        inOrder.verify(userRepository).findByUserNameAndIsDeleted("harold@manager.com",false);
        inOrder.verify(userMapper).convertToDto(null);
    }


}