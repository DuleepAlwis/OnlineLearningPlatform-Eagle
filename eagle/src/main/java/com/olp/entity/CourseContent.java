package com.olp.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name="course_content_tb")
@Entity
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

    public CourseContent() {
    }

    public CourseContent(long id, String name, int contentType, String location, String description, Date datePublished, CourseEntity course) {
        this.id = id;
        this.name = name;
        this.contentType = contentType;
        this.location = location;
        this.description = description;
        this.datePublished = datePublished;
        this.course = course;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getContentType() {
        return contentType;
    }

    public void setContentType(int contentType) {
        this.contentType = contentType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(Date datePublished) {
        this.datePublished = datePublished;
    }

    public CourseEntity getCourse() {
        return course;
    }

    public void setCourse(CourseEntity course) {
        this.course = course;
    }

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
