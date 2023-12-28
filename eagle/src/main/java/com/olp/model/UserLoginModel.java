package com.olp.model;

import lombok.Data;

import java.util.Date;

@Data
public class UserLoginModel {

    private long id;
    private String email;
    private String password;

    private String userName;
    private String role;

    private String activeStatus;

    private Date creationDate;


    private TutorModel userTutor;

    private StudentModel userStudent;


}
