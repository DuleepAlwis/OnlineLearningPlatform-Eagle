package com.olp.entity;

import javax.persistence.*;

import com.olp.constants.Role;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.Collection;

@Table(name="user_tb")
@Entity
@Data
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
    private Role role;

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
