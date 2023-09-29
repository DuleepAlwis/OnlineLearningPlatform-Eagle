package com.olp.entity;

import javax.persistence.*;

import java.sql.Date;

@Table(name="tutor_course_tb")
@Entity
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

    public TutorCourseEntity() {
    }

    public TutorCourseEntity(long id, TutorEntity tutor, CourseEntity tutorCourse, Date joinedDate) {
        this.id = id;
        this.tutor = tutor;
        this.tutorCourse = tutorCourse;
        this.joinedDate = joinedDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TutorEntity getTutor() {
        return tutor;
    }

    public void setTutor(TutorEntity tutor) {
        this.tutor = tutor;
    }

    public CourseEntity getTutorCourse() {
        return tutorCourse;
    }

    public void setTutorCourse(CourseEntity tutorCourse) {
        this.tutorCourse = tutorCourse;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

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
