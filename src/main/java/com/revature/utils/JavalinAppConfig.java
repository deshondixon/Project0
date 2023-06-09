package com.revature.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.revature.controllers.CardholderController;
import com.revature.controllers.PaymentController;
import io.javalin.Javalin;
import io.javalin.json.JsonMapper;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Type;

import static io.javalin.apibuilder.ApiBuilder.*;

public class JavalinAppConfig {

    private final Gson gson = new GsonBuilder().create();
    private final JsonMapper gsonMapper = new JsonMapper() {

        @NotNull
        @Override
        public String toJsonString(@NotNull Object obj, @NotNull Type type) {
            return gson.toJson(obj, type);
        }


        @NotNull
        @Override
        public <T> T fromJsonString(@NotNull String json, @NotNull Type targetType) {
            return gson.fromJson(json, targetType);
        }
    };

    private static final Logger logger = LoggerFactory.getLogger(JavalinAppConfig.class);

    private final PaymentController paymentController = new PaymentController();
    private final CardholderController cardholderController = new CardholderController();

    private final Javalin app = Javalin.create(config -> config.jsonMapper(gsonMapper))
            .before(ctx -> {
                logger.info(ctx.method() + " Request was sent to path: " + ctx.fullUrl());
            })

            .routes(() -> {

                path("payments", () -> {
                    get(paymentController::getAllPayments);
                    get("{id}", paymentController::getPaymentById);
                    post(paymentController::insertPayment);
                    put("{id}", paymentController::updatePayment);
                    delete("{id}", paymentController::deletePayment);
                });

                path("cardholders", () -> {
                    get(cardholderController::getAllCardholders);
                    get("{id}", cardholderController::getCardholderById);
                    post(cardholderController::insertCardholder);
                    put("{id}", cardholderController::updateCardholder);
                    delete("{id}", cardholderController::deleteCardholder);
                });
            });

    public void start(int port) {
        app.start(port);
    }
}
