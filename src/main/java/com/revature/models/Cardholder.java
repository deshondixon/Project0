package com.revature.models;

public class Cardholder {

    private int cardholder_id;
    private String firstName;
    private String lastName;

    public Cardholder(int cardholder_id, String firstName, String lastName) {
        this.cardholder_id = cardholder_id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getCardholder_id() {
        return cardholder_id;
    }

    public void setCardholder_id(int cardholder_id) {
        this.cardholder_id = cardholder_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Cardholder{" +
                "cardholder_id=" + cardholder_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}