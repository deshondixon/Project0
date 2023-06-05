package com.revature;

import com.revature.daos.CardholderDAO;
import com.revature.daos.PaymentDAO;
import com.revature.models.Cardholder;
import com.revature.models.Payment;
import io.javalin.http.Context;

import java.util.ArrayList;

public class SampleController {
    private CardholderDAO cardholderDAO = new CardholderDAO();
    private PaymentDAO paymentDAO = new PaymentDAO();

    public void getAllCardholders(Context ctx) {
        ArrayList<Cardholder> cardholderList = cardholderDAO.getAllCardholder();
        ctx.json(cardholderList);
    }

    public void getCardholderById(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Cardholder cardholder = cardholderDAO.getCardholderById(id);
        ctx.json(cardholder);
    }

    public void insertCardholder(Context ctx) {
        Cardholder cardholder = ctx.bodyAsClass(Cardholder.class);
        cardholderDAO.insertCardholder(cardholder);
        ctx.status(201);
    }

    public void updateCardholder(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Cardholder cardholder = ctx.bodyAsClass(Cardholder.class);
        cardholderDAO.updateCardholder(cardholder.getFirstName(), cardholder.getLastName(), id);
        ctx.status(200);
    }

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
}
