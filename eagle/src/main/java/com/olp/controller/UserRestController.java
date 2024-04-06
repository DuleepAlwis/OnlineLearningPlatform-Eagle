package com.olp.controller;

import com.olp.config.auth.JWTTokenHelper;
import com.olp.constants.ResponseMessage;
import com.olp.constants.Role;
import com.olp.entity.UserEntity;
import com.olp.model.GeneralResponseModel;
import com.olp.model.LoginModel;
import com.olp.model.LoginResponseModel;
import com.olp.model.UserLoginModel;
import com.olp.repository.UserRepository;
import com.olp.service.UserService;
import com.olp.utility.CommonUtitlity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Date;

@CrossOrigin()
@RestController
@RequestMapping(value="/api/user")
public class UserRestController {

    static Logger logger = LoggerFactory.getLogger(UserRestController.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping(value="/login")
    LoginResponseModel login(@RequestBody LoginModel creds) {

        LoginResponseModel loginResponseModel = new LoginResponseModel();
        UserEntity ue = null;//userRepository.findByEmailAndActiveStatus(creds.getEmail(),"Y");
        if(ue!=null){
            boolean passwordMatches = CommonUtitlity.passwordComparator(creds.getPassword(),ue.getPassword());
            if(passwordMatches){
                JWTTokenHelper jwt = new JWTTokenHelper();
                try {
                    String token = jwt.generateToken(ue);
                    loginResponseModel.setToken(token);
                    loginResponseModel.setResponseMessage(ResponseMessage.AUTHENTICATION_SUCCESS);
                    loginResponseModel.setResponseStatus(true);
                } catch (InvalidKeySpecException e) {
                    logger.info(e.getMessage());
                    loginResponseModel.setResponseMessage(e.getMessage());
                    loginResponseModel.setResponseStatus(false);
                } catch (NoSuchAlgorithmException e) {
                    logger.info(e.getMessage());
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

    @PostMapping(value = "/createUser")
    public GeneralResponseModel createUser(@RequestBody UserLoginModel user){

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
            ue = userService.createUser(ue);
            if(ue!=null){
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

}
