package com.revature.controllers;

import com.revature.daos.PaymentDAO;
import com.revature.models.Payment;
import io.javalin.http.Context;

import java.util.ArrayList;

public class PaymentController {
    private PaymentDAO paymentDAO = new PaymentDAO();

    public void getAllPayments(Context ctx) {
        ArrayList<Payment> paymentList = paymentDAO.getAllPayments();
        ctx.json(paymentList);
    }

    public void insertPayment(Context ctx) {
        Payment payment = ctx.bodyAsClass(Payment.class);
        paymentDAO.insertPayment(payment);
        ctx.status(201);
    }

    public void updatePayment(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Payment payment = ctx.bodyAsClass(Payment.class);
        paymentDAO.updatePayment(payment.getBill(), payment.getDueDate(), id);
        ctx.status(200);
    }

    public void deletePayment(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        paymentDAO.deletePayment(id);
        ctx.status(204);
    }
}
