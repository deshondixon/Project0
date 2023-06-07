package com.revature.controllers;

import com.revature.models.Cardholder;
import com.revature.service.CardholderService;
import com.revature.utils.JavalinAppConfig;
import io.javalin.http.Context;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class CardholderController {

    private static final Logger logger = LoggerFactory.getLogger(JavalinAppConfig.class);
    private static final CardholderService cardholderService = new CardholderService();

    public void getAllCardholders(Context ctx) {
        ArrayList<Cardholder> cardholderList = cardholderService.getAllCardholders();
        ctx.json(cardholderList);
    }

    public void getCardholderById(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Cardholder cardholder = cardholderService.getCardholderById(id);
        ctx.json(cardholder);
    }

    public void insertCardholder(Context ctx) {
        Cardholder cardholder = ctx.bodyAsClass(Cardholder.class);
        Cardholder insertedCardholder = cardholderService.insertCardholder(cardholder);
        if (insertedCardholder != null) {
            ctx.status(201);
            ctx.json(insertedCardholder);
        } else {
            ctx.status(400);
        }
    }

    public void updateCardholder(@NotNull Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Cardholder cardholder = ctx.bodyAsClass(Cardholder.class);
        if (cardholderService.updateCardholder(cardholder, id)) {
            ctx.status(204);
        } else {
            ctx.status(404);
        }
    }

    public void deleteCardholder(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        if (cardholderService.deleteCardholder(id)) {
            ctx.status(204);
        } else {
            ctx.status(404);
        }
    }



}
