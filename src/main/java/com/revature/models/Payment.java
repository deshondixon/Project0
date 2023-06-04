package com.revature.models;

public class Payment {

    private int payment_ID;
    private String bill;
    private String dueDate;
    private int cardholder_id_fk;

    public Payment(int payment_ID, String bill, String dueDate, int cardholder_id_fk) {
        this.payment_ID = payment_ID;
        this.bill = bill;
        this.dueDate = dueDate;
        this.cardholder_id_fk = cardholder_id_fk;
    }

    public int getPayment_ID() {
        return payment_ID;
    }

    public void setPayment_ID(int payment_ID) {
        this.payment_ID = payment_ID;
    }

    public String getBill() {
        return bill;
    }

    public void setBill(String bill) {
        this.bill = bill;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public int getCardholder_id_fk() {
        return cardholder_id_fk;
    }

    public void setCardholder_id_fk(int cardholder_id_fk) {
        this.cardholder_id_fk = cardholder_id_fk;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "payment_ID=" + payment_ID +
                ", bill='" + bill + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", cardholder_id_fk=" + cardholder_id_fk +
                '}';
    }
}