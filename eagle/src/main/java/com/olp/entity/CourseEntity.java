package com.olp.entity;

import lombok.Data;

import javax.persistence.*;

import java.util.List;

@Table(name="course_tb")
@Entity
@Data
public class CourseEntity {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="description",nullable = false)
    private String description;

    @Column(name="discount")
    private double discount;

    @Column(name="name")
    private String name;

    @Column(name="price")
    private double price;

    @Column(name="rating")
    private String rating;

   @OneToMany(mappedBy = "stCourse")
    private List<StudenCourseEntity> studentCourses;

   @OneToMany(mappedBy="tutorCourse")
    private List<TutorCourseEntity> tutors;

    @OneToMany(mappedBy = "course")
    private List<CourseContent> content;

    public List<CourseContent> getContent() {
        return content;
    }

    public void setContent(List<CourseContent> content) {
        this.content = content;
    }


    @Override
    public String toString() {
        return "CourseEntity{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", discount=" + discount +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", rating='" + rating + '\'' +
                ", studentCourses=" + studentCourses +
                ", tutors=" + tutors +
                '}';
    }
}
