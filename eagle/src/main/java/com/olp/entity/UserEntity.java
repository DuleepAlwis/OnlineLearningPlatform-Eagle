package com.olp.entity;

import javax.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Date;
import java.util.Collection;

@Table(name="user_tb")
@Entity
public class UserEntity implements UserDetails {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="username",unique = true,nullable = false)
    private String username;

    @Column(name="email",unique = true,nullable = false)
    private String email;

    @Column(name="password",nullable = false)
    private String password;

    @Column(name="role")
    private int role;

    @Column(name="active_status")
    private String activeStatus;

    @Column(name="creationDate")
    private Date creationDate;


    @OneToOne(mappedBy = "userTutor")
    private TutorEntity userTutor;

    @OneToOne(mappedBy = "userStudent")
    private StudentEntity userStudent;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return activeStatus.equals(("Y"));
    }

    @Override
    public boolean isAccountNonLocked() {

        return activeStatus.equals(("Y"));
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return activeStatus.equals(("Y"));
    }

    @Override
    public boolean isEnabled() {
        return activeStatus.equals(("Y"));
    }

    public UserEntity() {
    }

    public UserEntity(long id, String username, String email, String password, int role, String activeStatus, Date creationDate, TutorEntity userTutor, StudentEntity userStudent) {
        this.id = id;
        this.username = username;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
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

    public TutorEntity getUserTutor() {
        return userTutor;
    }

    public void setUserTutor(TutorEntity userTutor) {
        this.userTutor = userTutor;
    }

    public StudentEntity getUserStudent() {
        return userStudent;
    }

    public void setUserStudent(StudentEntity userStudent) {
        this.userStudent = userStudent;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
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
