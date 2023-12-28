package com.olp.model;

import lombok.Data;

import java.util.List;

@Data
public class CourseModel {

    private long id;
    private String description;
    private double discount;
    private String name;

    private double price;
    private String rating;

    private List<StudentModel> students;

    private List<TutorModel> tutors;


}
