package com.revature.daos;

import com.revature.models.Cardholder;
import com.revature.models.Payment;


public interface CardholderDAOInterface {

    //SELECT by ID
    Cardholder getCardholderById(int id);

    //INSERT
    Cardholder insertCardholder(Cardholder ch);

    //UPDATE Method
//    boolean updateName(String firstName, String lastName);
}
