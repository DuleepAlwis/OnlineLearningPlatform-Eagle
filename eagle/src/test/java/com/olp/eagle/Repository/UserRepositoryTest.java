package com.olp.eagle.Repository;

import com.olp.constants.Role;
import com.olp.entity.UserEntity;
import com.olp.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.meta.When;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    private UserEntity user;

    @BeforeEach
    public void setupTestData() {
        // Given : Setup object or precondition
        user = new UserEntity();
        user.setUsername("UserTest1");
        user.setEmail("UserTest1@gmail.com");
        user.setRole(Role.TUTOR);
        user.setPassword("UserTest123");
    }

    // JUnit Test for save employee operation
    @Test
    @DisplayName("JUnit test for save user operation")
    public void createUser(){




    }

}
