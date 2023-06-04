package com.revature.daos;

import com.revature.models.Cardholder;

import java.util.ArrayList;


public interface CardholderDAOInterface {

    //SELECT all CARDHOLDERS
    ArrayList<Cardholder> getAllCardholder();

    //SELECT by ID
    Cardholder getCardholderById(int id);

    //INSERT
    Cardholder insertCardholder(Cardholder ch);

    //UPDATE
    boolean updateCardholder(String firstName, String lastName);
}
