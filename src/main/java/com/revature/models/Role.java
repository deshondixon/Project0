package com.revature.models;

public class Role {
    private int role_id;
    private String role_title;
    private int role_salary;

    //no args
    public Role() {
    }

    //all args
    public Role(int role_id, String role_title, int role_salary) {
        this.role_id = role_id;
        this.role_title = role_title;
        this.role_salary = role_salary;
    }

    //all args minus id because is serial its generated automatically
    public Role(String role_title, int role_salary) {
        this.role_title = role_title;
        this.role_salary = role_salary;
    }

}
