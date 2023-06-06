package com.revature.models;

public class Cardholder {

    private int id;
    private String firstName;
    private String lastName;

    //---boilerplate---

    //no args
    public Cardholder() {
    }

    //all args
    public Cardholder(int cardholder_id, String firstName, String lastName) {
        this.id = cardholder_id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //all args no id
    public Cardholder(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public int getCardholder_id() {
        return id;
    }

    public void setCardholder_id(int cardholder_id) {
        this.id = cardholder_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Cardholder{" +
                "cardholder_id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }



}