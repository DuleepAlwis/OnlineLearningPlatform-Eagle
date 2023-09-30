package com.olp.model;

import java.sql.Date;

public class UserModel {

    private long id;
    private String email;
    private String password;

    private String userName;
    private String role;

    private String activeStatus;

    private Date creationDate;


    private TutorModel userTutor;

    private StudentModel userStudent;

    public UserModel() {
    }

    public UserModel(long id, String userName,String email, String password, String role, String activeStatus, Date creationDate, TutorModel userTutor, StudentModel userStudent) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.activeStatus = activeStatus;
        this.creationDate = creationDate;
        this.userTutor = userTutor;
        this.userStudent = userStudent;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getUserName(){
        return this.userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(String activeStatus) {
        this.activeStatus = activeStatus;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public TutorModel getUserTutor() {
        return userTutor;
    }

    public void setUserTutor(TutorModel userTutor) {
        this.userTutor = userTutor;
    }

    public StudentModel getUserStudent() {
        return userStudent;
    }

    public void setUserStudent(StudentModel userStudent) {
        this.userStudent = userStudent;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                "userName="+userName+'\''+
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", activeStatus='" + activeStatus + '\'' +
                ", creationDate=" + creationDate +
                ", userTutor=" + userTutor +
                ", userStudent=" + userStudent +
                '}';
    }
}
