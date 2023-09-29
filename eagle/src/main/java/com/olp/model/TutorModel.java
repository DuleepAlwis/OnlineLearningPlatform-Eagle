package com.olp.model;

import java.util.List;

public class TutorModel {

    //# id, address, city, country, district, gender, name, qualification, user_id
    private long id;

    private String address;
    private String city;
    private String district;
    private String gender;
    private String name;
    private String qualification;

    private UserModel user;
    private List<CourseModel> courses;

    public TutorModel() {
    }

    public TutorModel(long id, String address, String city, String district, String gender, String name, String qualification, UserModel user, List<CourseModel> courses) {
        this.id = id;
        this.address = address;
        this.city = city;
        this.district = district;
        this.gender = gender;
        this.name = name;
        this.qualification = qualification;
        this.user = user;
        this.courses = courses;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public List<CourseModel> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseModel> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "TutorModel{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", gender='" + gender + '\'' +
                ", name='" + name + '\'' +
                ", qualification='" + qualification + '\'' +
                ", user=" + user +
                ", courses=" + courses +
                '}';
    }
}
