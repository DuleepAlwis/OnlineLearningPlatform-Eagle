package com.olp.constants;

public enum Role {

    ADMIN(0,"ADMIN"),TUTOR(1,"TUTOR"),STUDENT(2,"STUDENT");

    private int index;
    private String roleValue;



    Role(int index, String role) {
        this.index = index;
        this.roleValue = role;
    }

    public String getRole(){
        return roleValue;
    }

    public void setRole(String role){
        roleValue = role;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
