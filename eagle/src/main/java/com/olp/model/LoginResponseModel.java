package com.olp.model;

import lombok.Data;

@Data
public class LoginResponseModel {

    private String responseMessage;
    private boolean responseStatus;

    private UserLoginModel userLoginModel;

    private String token;


}
