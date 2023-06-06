package com.revature.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.revature.controllers.PaymentController;
import com.revature.controllers.CardholderController;
import io.javalin.Javalin;
import io.javalin.json.JsonMapper;
import io.javalin.apibuilder.ApiBuilder.*;

import java.lang.reflect.Type;

public class JavalinAppConfig {

    private final Gson gson = new GsonBuilder().create();
    private final JsonMapper gsonMapper = new JsonMapper() {
        @Override
        public String toJsonString(@NotNull Object obj, @NotNull Type type) {
            return gson.toJson(obj, type);
        }

        @Override
        public <T> T fromJsonString(@NotNull String json, @NotNull Type targetType) {
            return gson.fromJson(json, targetType);
        }
    };

    private final PaymentController paymentController = new PaymentController();
    private final CardholderController cardholderController = new CardholderController();

    private Javalin app = Javalin.create(config -> config.jsonMapper(gsonMapper))
            .routes(() -> {

                path("payments", () -> {
                    get(paymentController::getAllPayments);
                    post(paymentController::insertPayment);
                    put(":id", paymentController::updatePayment);
                    delete(":id", paymentController::deletePayment);
                });

                path("cardholders", () -> {
                    get(cardholderController::getAllCardholders);
                    get(":id", cardholderController::getCardholderById);
                    post(cardholderController::insertCardholder);
                    put(":id", cardholderController::updateCardholder);
                });
            });

    public void start(int port){
        app.start(port);
    }
}
