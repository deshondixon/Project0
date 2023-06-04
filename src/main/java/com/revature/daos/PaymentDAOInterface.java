package com.revature.daos;

import com.revature.models.Cardholder;
import com.revature.models.Payment;
import java.util.ArrayList;

public interface PaymentDAOInterface {

    //SELECT all
    ArrayList<Payment> getAllPayments();

    //SELECT by ID
    Payment getPaymentById(int id);

    //INSERT method
    Payment insertPayment(Payment pay);

    //UPDATE
    boolean updatePayment(String bill, String due_date);
}
