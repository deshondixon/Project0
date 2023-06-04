package com.revature.daos;

import com.revature.models.Cardholder;


public interface CardholderDAOInterface {

    //SELECT by ID
    Cardholder getCardholderById(int id);

    //UPDATE Method
//    boolean updateName(String firstName, String lastName);
}
