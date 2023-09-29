package com.olp.model;

import java.util.List;

public class CourseModel {

    private long id;
    private String description;
    private double discount;
    private String name;

    private double price;
    private String rating;

    private List<StudentModel> students;

    private List<TutorModel> tutors;

    public CourseModel() {
    }

    public CourseModel(long id, String description, double discount, String name, double price, String rating, List<StudentModel> students, List<TutorModel> tutors) {
        this.id = id;
        this.description = description;
        this.discount = discount;
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.students = students;
        this.tutors = tutors;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public List<StudentModel> getStudents() {
        return students;
    }

    public void setStudents(List<StudentModel> students) {
        this.students = students;
    }

    public List<TutorModel> getTutors() {
        return tutors;
    }

    public void setTutors(List<TutorModel> tutors) {
        this.tutors = tutors;
    }

    @Override
    public String toString() {
        return "CourseModel{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", discount=" + discount +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", rating='" + rating + '\'' +
                ", students=" + students +
                ", tutors=" + tutors +
                '}';
    }
}
