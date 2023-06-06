package com.revature;

import com.revature.contollers.CardholderController;
import com.revature.contollers.PaymentController;
import com.revature.utils.ConnectionUtil;
import io.javalin.Javalin;
import java.sql.Connection;
import java.sql.SQLException;

public class Launcher {
    public static void main(String[] args) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            System.out.println("CONNECTION SUCCESSFUL :)");
        } catch (SQLException e) {
            System.out.println("Connection Failed :(");
        }

        var app = Javalin.create().start(7070);

        CardholderController cardholderController = new CardholderController();
        PaymentController paymentController = new PaymentController();

        //-------CARDHOLDER----------

        app.get("/cardholders", cardholderController::getAllCardholders);
        app.get("/cardholders/{id}", cardholderController::getCardholderById);
        app.post("/cardholders", cardholderController::insertCardholder);
        app.put("/cardholders/{id}", cardholderController::updateCardholder);

        //-------PAYMENTS----------

        app.get("/payments", paymentController::getAllPayments);
        app.post("/payments", paymentController::insertPayment);
        app.put("/payments/{id}", paymentController::updatePayment);
        app.delete("/payments/{id}", paymentController::deletePayment);
    }
}
