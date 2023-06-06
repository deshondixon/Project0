package com.revature.utils;

import com.revature.controllers.PaymentController;
import com.revature.controllers.CardholderController;
import io.javalin.Javalin;

public class JavalinAppConfig {

    private final PaymentController paymentController = new PaymentController();
    private final CardholderController cardholderController = new CardholderController();

    private Javalin app = Javalin.create(config -> config.jsonMapper(gsonMapper))
            .routes(() -> {

                path("payments", () -> {
                    get(paymentController::getAllPayments);
                    post(paymentController::insertPayment);
                    put("{id}", paymentController::updatePayment);
                    delete("{id}", paymentController::deletePayment);
                });

                path("cardholders", () -> {
                    get(cardholderController::getAllCardholders);
                    get("{id}", cardholderController::getCardholderById);
                    post(cardholderController::insertCardholder);
                    put("{id}", cardholderController::updateCardholder);
                });
            });

    public void start(int port){
        app.start(port);
    }
}
