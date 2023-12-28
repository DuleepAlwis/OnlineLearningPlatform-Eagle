package com.olp.entity;

import lombok.Data;

import javax.persistence.*;

import java.util.List;

@Table(name="student_tb")
@Entity
@Data
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
