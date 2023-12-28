package com.olp.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table(name="course_content_tb")
@Entity
@Data
public class CourseContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="content_type")
    private int contentType;

    @Column(name="location")
    private String location;

    @Column(name="description")
    private String description;

    @Column(name="date_published")
    private Date datePublished;

    @ManyToOne
    @JoinColumn(name="course_id", nullable=false)
    private CourseEntity course;

    @Override
    public String toString() {
        return "CourseContent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contentType=" + contentType +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", datePublished=" + datePublished +
                ", course=" + course +
                '}';
    }
}
