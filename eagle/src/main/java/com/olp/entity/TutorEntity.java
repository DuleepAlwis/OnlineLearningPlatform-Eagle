package com.olp.entity;

import lombok.Data;

import javax.persistence.*;

import java.util.List;

@Table(name="tutor_tb")
@Entity
@Data
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
