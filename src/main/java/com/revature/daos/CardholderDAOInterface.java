package com.revature.daos;

import com.revature.models.Cardholder;

import java.util.ArrayList;


public interface CardholderDAOInterface {
    ArrayList<Cardholder> getAllCardholder();

    Cardholder getCardholderById(int id);

    Cardholder insertCardholder(Cardholder ch);

    boolean updateCardholder(String first_name, String last_name, int cardholder_id);
}
