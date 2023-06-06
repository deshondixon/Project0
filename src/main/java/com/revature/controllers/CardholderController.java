package com.revature.controllers;

import com.revature.daos.CardholderDAO;
import com.revature.models.Cardholder;
import io.javalin.http.Context;

import java.util.ArrayList;

public class CardholderController {
    private CardholderDAO cardholderDAO = new CardholderDAO();

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
}
