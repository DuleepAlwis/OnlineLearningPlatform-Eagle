package com.olp.model;


import lombok.Data;

import java.util.List;
@Data
public class StudentModel {

    // # id, address, city, country, district, gender, name, user_id

    private long id;
    private String address;
    private String city;
    private String country;
    private String district;
    private String gender;
    private String name;
    private UserLoginModel user;

    private List<CourseModel> courses;


}
