package com.olp.entity;

import javax.persistence.*;

import java.util.List;

@Table(name="course_tb")
@Entity
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

    public CourseEntity() {
    }

    public CourseEntity(long id, String description, double discount, String name, double price, String rating, List<StudenCourseEntity> studentCourses, List<TutorCourseEntity> tutors) {
        this.id = id;
        this.description = description;
        this.discount = discount;
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.studentCourses = studentCourses;
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

    public List<StudenCourseEntity> getStudentCourses() {
        return studentCourses;
    }

    public void setStudentCourses(List<StudenCourseEntity> studentCourses) {
        this.studentCourses = studentCourses;
    }

    public List<TutorCourseEntity> getTutors() {
        return tutors;
    }

    public void setTutors(List<TutorCourseEntity> tutors) {
        this.tutors = tutors;
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
