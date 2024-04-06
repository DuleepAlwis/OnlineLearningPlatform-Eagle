package com.olp.controller;

import com.olp.config.auth.JWTTokenHelper;
import com.olp.constants.ResponseMessage;
import com.olp.constants.Role;
import com.olp.entity.UserEntity;
import com.olp.model.GeneralResponseModel;
import com.olp.model.LoginResponseModel;
import com.olp.model.UserLoginModel;
import com.olp.repository.UserRepository;
import com.olp.service.UserService;
import com.olp.utility.CommonUtitlity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Date;

//@CrossOrigin(origins = "http://localhost:3000")
@Controller
public class UserController {

    static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @MutationMapping
    LoginResponseModel login(@Argument String email, @Argument String password) {

        LoginResponseModel loginResponseModel = new LoginResponseModel();
        UserEntity ue = userService.findByEmailAndActiveStatus(email,"Y");
        UserLoginModel userModel = new UserLoginModel();
        if(ue!=null){
            boolean passwordMatches = CommonUtitlity.passwordComparator(password,ue.getPassword());
            if(passwordMatches){
                JWTTokenHelper jwt = new JWTTokenHelper();
                try {
                    String token = jwt.generateToken(ue);
                    loginResponseModel.setToken(token);
                    loginResponseModel.setResponseMessage(ResponseMessage.AUTHENTICATION_SUCCESS);

                    loginResponseModel.setResponseStatus(true);
                    switch (ue.getRole()){
                        case  ADMIN:userModel.setRole(Role.ADMIN.getRole());break;
                        case STUDENT:userModel.setRole(Role.STUDENT.getRole());break;
                        case TUTOR:userModel.setRole(Role.TUTOR.getRole());break;
                    }
                    userModel.setUserName(ue.getUsername());
                    userModel.setEmail(ue.getEmail());
                    userModel.setCreationDate(ue.getCreationDate());
                    userModel.setId(ue.getId());
                    userModel.setActiveStatus(ue.getActiveStatus());
                    loginResponseModel.setUserLoginModel(userModel);
                    logger.info("User entity {}",loginResponseModel.getUserLoginModel().toString());
                } catch (InvalidKeySpecException e) {
                   logger.info("Error {}",e.getMessage());
                   loginResponseModel.setResponseMessage(e.getMessage());
                   loginResponseModel.setResponseStatus(false);

                } catch (NoSuchAlgorithmException e) {
                    logger.info("Error {}",e.getMessage());
                    loginResponseModel.setResponseStatus(false);
                    loginResponseModel.setResponseMessage(e.getMessage());

                }
            }else{
                loginResponseModel.setResponseMessage(ResponseMessage.INVALID_EMAIL_PASSWORD);
                loginResponseModel.setResponseStatus(false);

            }
        }else{
            loginResponseModel.setResponseMessage(ResponseMessage.INVALID_EMAIL_PASSWORD);
            loginResponseModel.setResponseStatus(false);

        }
        return loginResponseModel;
    }

    @MutationMapping
    public GeneralResponseModel createUser(@Argument UserLoginModel user){

        GeneralResponseModel generalResponseModel = new GeneralResponseModel();
        UserEntity ue = new UserEntity();
        ue.setActiveStatus("Y");
        ue.setCreationDate(new Date());
        if(user.getRole().equals(Role.ADMIN.getRole())){
            ue.setRole(Role.ADMIN);
        }else if(user.getRole().equals(Role.STUDENT.getRole())){
            ue.setRole(Role.STUDENT);
        }else if(user.getRole().equals(Role.TUTOR.getRole())){
            ue.setRole(Role.TUTOR);
        }
        ue.setEmail(user.getEmail());
        ue.setPassword(CommonUtitlity.hashPassword(user.getPassword()));
        ue.setUsername(user.getUserName());
        try{
            if(userService.createUser(ue)!=null){
                generalResponseModel.setResponseMessage(ResponseMessage.ACCOUNT_CREATION_SUCCESS);
                generalResponseModel.setResponseStatus(true);
            }else{
                generalResponseModel.setResponseMessage(ResponseMessage.ACCOUNT_CREATION_FAILED);
                generalResponseModel.setResponseStatus(false);
            }
        }catch (Exception ex){
            generalResponseModel.setResponseMessage(ex.getMessage());
            generalResponseModel.setResponseStatus(false);
        }

        return generalResponseModel;
    }

    @MutationMapping
    public GeneralResponseModel changePassword(@Argument Long userId,@Argument String password){
        GeneralResponseModel generalResponseModel = new GeneralResponseModel();
        UserEntity ue =  this.userService.getUserById(userId);
        ue.setPassword(CommonUtitlity.hashPassword(password));
        if(this.userService.createUser(ue)!=null){
            generalResponseModel.setResponseMessage(ResponseMessage.RESET_PW_SUCCESS);
            generalResponseModel.setResponseStatus(true);
        }else{
            generalResponseModel.setResponseMessage(ResponseMessage.RESET_PW_FAILED);
            generalResponseModel.setResponseStatus(false);
        }
        return generalResponseModel;
    }

    @MutationMapping
    public GeneralResponseModel updateUser(@Argument UserLoginModel user){
        GeneralResponseModel generalResponseModel = new GeneralResponseModel();
        UserEntity ue = userService.getUserById(user.getId());
        ue.setUsername(user.getUserName());
        ue.setEmail(user.getEmail());
        if(userService.createUser(ue)!=null){
            generalResponseModel.setResponseMessage(ResponseMessage.ACCOUNT_DATA_UPDATION_SUCCESS);
            generalResponseModel.setResponseStatus(true);
        }else{
            generalResponseModel.setResponseMessage(ResponseMessage.ACCOUNT_DATA_UPDATION_FAILED);
            generalResponseModel.setResponseStatus(true);
        }
        return generalResponseModel;
    }
}
