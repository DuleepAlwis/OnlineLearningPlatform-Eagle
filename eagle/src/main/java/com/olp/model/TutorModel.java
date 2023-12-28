package com.olp.model;

import lombok.Data;

import java.util.List;

@Data
public class TutorModel {

    //# id, address, city, country, district, gender, name, qualification, user_id
    private long id;

    private String address;
    private String city;
    private String district;
    private String gender;
    private String name;
    private String qualification;

    private UserLoginModel user;
    private List<CourseModel> courses;


}
