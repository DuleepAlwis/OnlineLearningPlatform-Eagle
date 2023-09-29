package com.olp.model;


import java.util.List;

public class StudentModel {

    // # id, address, city, country, district, gender, name, user_id

    private long id;
    private String address;
    private String city;
    private String country;
    private String district;
    private String gender;
    private String name;
    private UserModel user;

    private List<CourseModel> courses;

    public StudentModel() {
    }

    public StudentModel(long id, String address, String city, String country, String district, String gender, String name, UserModel user, List<CourseModel> courses) {
        this.id = id;
        this.address = address;
        this.city = city;
        this.country = country;
        this.district = district;
        this.gender = gender;
        this.name = name;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
        return "StudentModel{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", district='" + district + '\'' +
                ", gender='" + gender + '\'' +
                ", name='" + name + '\'' +
                ", user=" + user +
                ", courses=" + courses +
                '}';
    }
}
