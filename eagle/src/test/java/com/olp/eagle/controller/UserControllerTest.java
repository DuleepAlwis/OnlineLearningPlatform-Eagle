package com.olp.eagle.controller;

import com.olp.constants.ResponseMessage;
import com.olp.constants.Role;
import com.olp.controller.UserController;
import com.olp.controller.UserRestController;
import com.olp.entity.UserEntity;
import com.olp.model.UserLoginModel;
import com.olp.repository.UserRepository;
import com.olp.service.UserService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ComponentScan(basePackages = {"com.olp.service", "com.olp.controller"})
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private UserService userService;
    @InjectMocks
    private UserController userController;

    @MockBean
    private UserRepository userRepository2;

    @MockBean
    private UserService userService2;

    @InjectMocks
    private UserRestController userRestController;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void createUser(){
        UserLoginModel userLoginModel = new UserLoginModel();
        userLoginModel.setEmail("UserTest2@gmail.com");
        userLoginModel.setPassword("user123");
        userLoginModel.setUserName("UserTest2");
        userLoginModel.setRole(Role.TUTOR.getRole());
        UserEntity ue = new UserEntity();
        ue.setEmail(userLoginModel.getEmail());
        ue.setPassword(userLoginModel.getPassword());
        ue.setUsername(userLoginModel.getUserName());
        if(userLoginModel.getRole().equals(Role.ADMIN.getRole())){
            ue.setRole(Role.ADMIN);
        }else if(userLoginModel.getRole().equals(Role.STUDENT.getRole())){
            ue.setRole(Role.STUDENT);
        }else if(userLoginModel.getRole().equals(Role.TUTOR.getRole())){
            ue.setRole(Role.TUTOR);
        }
        //userService.save(ue);
        Assertions.assertEquals(ResponseMessage.ACCOUNT_CREATION_SUCCESS,userRestController.createUser(userLoginModel).getResponseMessage());
    }

    @Autowired
    private MockMvc mockMvc;



    @Test
    public void testCreateUser() throws Exception {
        // Mock the behavior of userService.createUser method
        UserEntity mockedUserEntity = new UserEntity(); // Create a mocked UserEntity
        when(userService2.createUser(any(UserEntity.class))).thenReturn(mockedUserEntity);

        // Prepare a JSON string representing the user data
        String userJson = "{ \"email\": \"test@example.com\", \"role\": \"ADMIN\", \"userName\": \"testuser\", \"password\": \"password\" }";

        // Perform a POST request to the createUser endpoint with the userJson content
        mockMvc.perform(MockMvcRequestBuilders.post("/api/user/createUser")
                        .content(userJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk()); // Assert HTTP status is OK (200)
                //.andExpect(MockMvcResultMatchers.jsonPath("$.responseMessage").exists()); // Assert the response contains an ID field

    }
}
