package com.olp.eagle.Service;

import com.olp.constants.Role;
import com.olp.entity.UserEntity;
import com.olp.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void createUser(){
        UserService userServiceMock = mock(UserService.class);

        // Define the behavior of the saveUser method on the mock object
        // For example, return a specific value when saveUser is called
        UserEntity user = new UserEntity(); // Create a user object for testing
        user = new UserEntity();
        user.setUsername("UserTest1");
        user.setEmail("UserTest1@gmail.com");
        user.setRole(Role.TUTOR);
        user.setPassword("UserTest123");
        when(userServiceMock.createUser(user)).thenReturn(user); // Return the same user object

        // Call the method you want to test
        UserEntity savedUser = userServiceMock.createUser(user);

        // Assert the behavior or outcome of the method call
        // For example, assert that the returned user object is the same as the one passed in
        assertThat(savedUser).isSameAs(user);
    }
}
