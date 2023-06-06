package com.revature.controllers;

import com.revature.models.Cardholder;
import com.revature.service.CardholderService;
import io.javalin.http.Context;

import java.util.ArrayList;

public class CardholderController {

    private CardholderService cardholderService = new CardholderService();

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

    public void updateCardholder(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Cardholder cardholder = ctx.bodyAsClass(Cardholder.class);
        boolean updated = cardholderService.updateCardholder(cardholder, id);
        if (updated) {
            ctx.status(200);
            ctx.json(cardholder);
        } else {
            ctx.status(400);
        }
    }
}
