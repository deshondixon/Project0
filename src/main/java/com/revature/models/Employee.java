package com.revature.models;

public class Employee {

    //in our model classes, we need to directly reflect our DB tables

    //we need a variable for every DB column
    private int employee_id;

    private String first_name;

    private String last_name;


    //boilerplate code below----------------------

    //no args
    public Employee() {
    }

    //all args
    public Employee(int employee_id, String first_name, String last_name) {
        this.employee_id = employee_id;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    //all args minus id - the id is serial, so it's generated automatically
    //if we were to create a new Role, we wouldn't have to worry about including the primary key
    public Employee(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    //toString() lets us print out our objects in String form (instead of memory address)
    @Override
    public String toString() {
        return "Employee{" +
                "employee_id=" + employee_id +
                ", first_name='" + first_name + '\'' +
                ", last_name=" + last_name +
                '}';
    }
}
