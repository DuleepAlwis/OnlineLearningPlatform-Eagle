package com.olp.entity;

import lombok.Data;

import javax.persistence.*;

import java.util.Date;

@Table(name="tutor_course_tb")
@Entity
@Data
public class TutorCourseEntity {

    //# id, course_id, tutor_id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @ManyToOne
    @JoinColumn(name="tutor_id", nullable=false)
    private TutorEntity tutor;

    @ManyToOne
    @JoinColumn(name="tutor_course_id",nullable = false)
    private CourseEntity tutorCourse;

    @Column(name="joined_date")
    private Date joinedDate;


    @Override
    public String toString() {
        return "TutorCourseEntity{" +
                "id=" + id +
                ", tutor=" + tutor +
                ", tutorCourse=" + tutorCourse +
                ", joinedDate=" + joinedDate +
                '}';
    }
}
