package com.revature.daos;

import com.revature.models.Payment;

import java.util.ArrayList;

public interface PaymentDAOInterface {
    ArrayList<Payment> getAllPayments();

    Payment getPaymentById(int id);

    Payment insertPayment(Payment pay);

    boolean updatePayment(String bill, String due_date, int payment_id);

    boolean deletePayment(int id);
}
