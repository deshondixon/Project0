package com.revature.daos;

import com.revature.models.Payment;
import java.util.ArrayList;

public interface PaymentDAOInterface {

    //SELECT all
    ArrayList<Payment> getAllPayments();

    //INSERT method
    Payment insertPayment(Payment pay);
}
