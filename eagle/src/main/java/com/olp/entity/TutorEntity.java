package com.olp.entity;

import javax.persistence.*;

import java.util.List;

@Table(name="tutor_tb")
@Entity
public class TutorEntity {

    //# id, address, city, country, district, gender, name, qualification, user_id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="address")
    private String address;

    @Column(name="city")
    private String city;

    @Column(name="country")
    private String country;

    @Column(name="district")
    private String district;

    @Column(name="gender")
    private String gender;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name="qualification")
    private String qualification;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity userTutor;

   @OneToMany(mappedBy = "tutor")
    private List<TutorCourseEntity> courses;

    public TutorEntity() {
    }

    public TutorEntity(long id, String address, String city, String country, String district, String gender, String name, String qualification, UserEntity userTutor, List<TutorCourseEntity> courses) {
        this.id = id;
        this.address = address;
        this.city = city;
        this.country = country;
        this.district = district;
        this.gender = gender;
        this.name = name;
        this.qualification = qualification;
        this.userTutor = userTutor;
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

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public UserEntity getUserTutor() {
        return userTutor;
    }

    public void setUserTutor(UserEntity userTutor) {
        this.userTutor = userTutor;
    }

    public List<TutorCourseEntity> getCourses() {
        return courses;
    }

    public void setCourses(List<TutorCourseEntity> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "TutorEntity{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", district='" + district + '\'' +
                ", gender='" + gender + '\'' +
                ", name='" + name + '\'' +
                ", qualification='" + qualification + '\'' +
                ", userTutor=" + userTutor +
                ", courses=" + courses +
                '}';
    }
}
