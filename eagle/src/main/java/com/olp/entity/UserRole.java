package com.olp.entity;

import javax.persistence.*;

@Table(name="UserRole_tb")
@Entity
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="permission",unique = true,nullable = false)
    private String permission;

    public UserRole() {
    }

    public UserRole(long id, String permission) {
        this.id = id;
        this.permission = permission;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", permission='" + permission + '\'' +
                '}';
    }
}
