package com.revature;

import com.revature.daos.CardholderDAO;
import com.revature.daos.PaymentDAO;
import com.revature.models.Cardholder;
import com.revature.models.Payment;
import com.revature.utils.ConnectionUtil;

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


        //-------- DAO ----------

        //SELECT CARDHOLDER
        CardholderDAO cDAO = new CardholderDAO();
//        System.out.println(cDAO.getCardholderById(3));

        //INSERT CARDHOLDER
//        Cardholder deshon = new Cardholder(5,"DeShon", "Dixon");
//        Cardholder nicole = new Cardholder(6,"Nicole", "Smith");
//        System.out.println(cDAO.insertCardholder(deshon));
//        System.out.println(cDAO.insertCardholder(nicole));

        //INSERT PAYMENT
//        PaymentDAO pDAO = new PaymentDAO();
//        Payment deshonPay = new Payment("paid", "June 18th", 5);
//        Payment nicolePay = new Payment("paid", "June 19th", 6);
//        System.out.println(pDAO.insertPayment(deshonPay));
//        System.out.println(pDAO.insertPayment(nicolePay));

        //UPDATE
//        System.out.println(cDAO.updateRoleSalary(500000, "Manager"));
//        System.out.println(cDAO.getRoleById(1)); //checking if the Manager salary was updated

        //GET All CARDHOLDERS
        ArrayList<Cardholder> cardholderList = cDAO.getAllCardholder();

        for(Cardholder c : cardholderList){
            System.out.println(c);
        }

    }
}
