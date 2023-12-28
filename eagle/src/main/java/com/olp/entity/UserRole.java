package com.olp.entity;

import lombok.Data;

import javax.persistence.*;

@Table(name="UserRole_tb")
@Entity
@Data
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="permission",unique = true,nullable = false)
    private String permission;
    
    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", permission='" + permission + '\'' +
                '}';
    }
}
