package com.olp.entity;

import javax.persistence.*;

import java.sql.Date;

@Table(name="student_course_tb")
@Entity
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

    public StudenCourseEntity() {
    }

    public StudenCourseEntity(long id, StudentEntity student, CourseEntity stCourse, Date enrolledDate) {
        this.id = id;
        this.student = student;
        this.stCourse = stCourse;
        this.enrolledDate = enrolledDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }

    public CourseEntity getStCourse() {
        return stCourse;
    }

    public void setStCourse(CourseEntity stCourse) {
        this.stCourse = stCourse;
    }

    public Date getEnrolledDate() {
        return enrolledDate;
    }

    public void setEnrolledDate(Date enrolledDate) {
        this.enrolledDate = enrolledDate;
    }

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
