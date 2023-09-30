package com.olp.constants;

public enum Role {

    ADMIN("ADMIN"),TUTOR("TUTOR"),STUDENT("STUDENT");

    private String roleValue;
    Role(String role) {
        this.roleValue = role;
    }

    public String getRole(){
        return roleValue;
    }

    public void setRole(String role){
        roleValue = role;
    }
}
