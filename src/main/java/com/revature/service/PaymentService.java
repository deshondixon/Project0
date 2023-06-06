package com.revature.service;

import com.revature.daos.PaymentDAO;
import com.revature.models.Payment;

import java.util.ArrayList;

public class PaymentService {
    private PaymentDAO paymentDAO = new PaymentDAO();

    public ArrayList<Payment> getAllPayments() {
        return paymentDAO.getAllPayments();
    }

    public Payment insertPayment(Payment payment) {
        return paymentDAO.insertPayment(payment);
    }

    public boolean updatePayment(String bill, String dueDate, int paymentId) {
        return paymentDAO.updatePayment(bill, dueDate, paymentId);
    }

    public boolean deletePayment(int id) {
        return paymentDAO.deletePayment(id);
    }
}
