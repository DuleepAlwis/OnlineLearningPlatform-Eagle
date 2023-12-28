package com.olp.entity;

import lombok.Data;

import javax.persistence.*;

import java.util.Date;

@Table(name="student_course_tb")
@Entity
@Data
public class StudenCourseEntity {

    //# id, student_id, tutor_course_id,enrolled_date

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @ManyToOne
    @JoinColumn(name="student_id", nullable=false)
    private StudentEntity student;

    @ManyToOne
    @JoinColumn(name="student_course_id",nullable = false)
    private CourseEntity stCourse;

    @Column(name="enrolled_date")
    private Date enrolledDate;


    @Override
    public String toString() {
        return "StudenCourseEntity{" +
                "id=" + id +
                ", student=" + student +
                ", stCourse=" + stCourse +
                ", enrolledDate=" + enrolledDate +
                '}';
    }
}
