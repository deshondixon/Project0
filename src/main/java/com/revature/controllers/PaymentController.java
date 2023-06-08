package com.revature.controllers;

import com.revature.service.PaymentService;
import com.revature.models.Payment;
import com.revature.utils.JavalinAppConfig;
import io.javalin.http.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class PaymentController {
    private static final Logger logger = LoggerFactory.getLogger(JavalinAppConfig.class);
    private static final PaymentService paymentService = new PaymentService();

    public void getAllPayments(Context ctx) {
        ArrayList<Payment> paymentList = paymentService.getAllPayments();
        ctx.json(paymentList);
    }

    public void getPaymentById(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            ctx.status(200);
            ctx.json(payment);
        } else {
            ctx.status(404);
        }
    }

    public void insertPayment(Context ctx) {
        Payment payment = ctx.bodyAsClass(Payment.class);
        Payment insertedPayment = paymentService.insertPayment(payment);
        if (insertedPayment != null) {
            ctx.status(201);
            ctx.json(insertedPayment);
        } else {
            ctx.status(400);
        }
    }

    public void updatePayment(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Payment payment = ctx.bodyAsClass(Payment.class);
        boolean updated = paymentService.updatePayment(payment.getBill(), payment.getDueDate(), id);
        if (updated) {
            ctx.status(200);
            ctx.result("Payment updated successfully");
        } else {
            ctx.status(400);
        }
    }

    public void deletePayment(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        boolean deleted = paymentService.deletePayment(id);
        if (deleted) {
            ctx.status(200);
            ctx.result("Payment deleted successfully");
        } else {
            ctx.status(400);
        }
    }
}
