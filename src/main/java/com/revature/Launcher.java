package com.revature;

import com.revature.daos.CardholderDAO;
import com.revature.daos.PaymentDAO;
import com.revature.models.Cardholder;
import com.revature.models.Payment;
import com.revature.utils.ConnectionUtil;
import io.javalin.Javalin;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class Launcher {
    public static void main(String[] args) {

        try(Connection conn = ConnectionUtil.getConnection()){
            System.out.println("CONNECTION SUCCESSFUL :)");
        }
        catch(SQLException e){
            System.out.println("Connection Failed :(" );
        }

        var app = Javalin.create(/*config*/)
                .get("/", ctx -> ctx.result("Hello World"))
                .start(7070);


        //------------------------------- DAO ---------------------------

        //-------- CARDHOLDER ----------
        System.out.println("-------- CARDHOLDER ----------");


//      CardholderDAO cDAO = new CardholderDAO();

        //GET All CARDHOLDERS
//        ArrayList<Cardholder> cardholderList = cDAO.getAllCardholder();
//
//        for(Cardholder c : cardholderList){
//            System.out.println(c);
//        }

        //SELECT CARDHOLDER BY ID
//        System.out.println(cDAO.getCardholderById(3));

        //INSERT CARDHOLDER
//        Cardholder deshon = new Cardholder(5,"DeShon", "Dixon");
//        Cardholder nicole = new Cardholder(6,"Nicole", "Smith");
//        System.out.println(cDAO.insertCardholder(deshon));
//        System.out.println(cDAO.insertCardholder(nicole));

        //UPDATE
//        System.out.println(cDAO.updateCardholder("Anthony", "Martin", 5));
//        System.out.println(cDAO.getCardholderById(5));

        //-------- PAYMENT ----------
        System.out.println("-------- PAYMENT ----------");


//      PaymentDAO pDAO = new PaymentDAO();

        //GET All PAYMENTS
//        ArrayList<Payment> paymentList = pDAO.getAllPayments();
//
//        for(Payment p : paymentList){
//            System.out.println(p);
//        }

        //INSERT PAYMENTS
//        Payment deshonPay = new Payment("paid", "June 18th", 5);
//        Payment nicolePay = new Payment("paid", "June 19th", 6);
//        System.out.println(pDAO.insertPayment(deshonPay));
//        System.out.println(pDAO.insertPayment(nicolePay));

//UPDATE
//        System.out.println(pDAO.updatePayment("Paid", "July 11th", 5));
//        System.out.println(pDAO.getPaymentById(5));

    }
}
