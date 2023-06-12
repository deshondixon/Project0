package com.revature.service;

import com.revature.daos.CardholderDAO;
import com.revature.daos.CardholderDAOInterface;
import com.revature.models.Cardholder;

import java.util.ArrayList;

public class CardholderService {

    private CardholderDAOInterface cardholderDAO = new CardholderDAO();

    public CardholderService() {
    }


    public ArrayList<Cardholder> getAllCardholders() {

        return cardholderDAO.getAllCardholder();
    }

    public Cardholder getCardholderById(int id) {

        return cardholderDAO.getCardholderById(id);
    }

    public Cardholder insertCardholder(Cardholder cardholder) {

        return cardholderDAO.insertCardholder(cardholder);
    }

    public boolean updateCardholder(Cardholder cardholder, int id) {
        return cardholderDAO.updateCardholder(cardholder.getFirstName(), cardholder.getLastName(), id);
    }

    public boolean deleteCardholder(int id) {
        return cardholderDAO.deleteCardholder(id);
    }


}
