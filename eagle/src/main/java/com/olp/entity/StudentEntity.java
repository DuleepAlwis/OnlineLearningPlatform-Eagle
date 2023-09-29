package com.olp.entity;

import javax.persistence.*;

import java.util.List;

@Table(name="student_tb")
@Entity
public class StudentEntity {

   // # id, address, city, country, district, gender, name, user_id
   @Id
   @Column(name = "id", unique = true, nullable = false)
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;

   @Column(name="address")
    private String address;

   @Column(name="city")
    private String city;

   @Column(name="district")
    private String district;

   @Column(name="gender")
    private String gender;

   @Column(name="name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity userStudent;

   @OneToMany(mappedBy = "student")
    private List<StudenCourseEntity> stCourses;

    public StudentEntity() {
    }

    public StudentEntity(long id, String address, String city, String district, String gender, String name, UserEntity userStudent, List<StudenCourseEntity> stCourses) {
        this.id = id;
        this.address = address;
        this.city = city;
        this.district = district;
        this.gender = gender;
        this.name = name;
        this.userStudent = userStudent;
        this.stCourses = stCourses;
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

    public UserEntity getUserStudent() {
        return userStudent;
    }

    public void setUserStudent(UserEntity userStudent) {
        this.userStudent = userStudent;
    }

    public List<StudenCourseEntity> getStCourses() {
        return stCourses;
    }

    public void setStCourses(List<StudenCourseEntity> stCourses) {
        this.stCourses = stCourses;
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", gender='" + gender + '\'' +
                ", name='" + name + '\'' +
                ", userStudent=" + userStudent +
                ", stCourses=" + stCourses +
                '}';
    }
}
