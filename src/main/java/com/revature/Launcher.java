package com.revature;

import com.revature.daos.CardholderDAO;
import com.revature.models.Cardholder;
import com.revature.models.Payment;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class Launcher {
    public static void main(String[] args) {
        try(Connection conn = ConnectionUtil.getConnection()){
            System.out.println("CONNECTION SUCCESSFUL :)");
        }
        catch(SQLException e){
            System.out.println("Connection Failed :(" );
        }


        //-------- DAO ----------

        //SELECT
        CardholderDAO cDAO = new CardholderDAO();
        System.out.println(cDAO.getCardholderById(3));

        //INSERT CARDHOLDER
        Cardholder deshon = new Cardholder(5,"DeShon", "Dixon");
        Cardholder nicole = new Cardholder(6,"Nicole", "Smith");
        System.out.println(cDAO.insertCardholder(deshon));
        System.out.println(cDAO.insertCardholder(nicole));

        //UPDATE
//        System.out.println(cDAO.updateRoleSalary(500000, "Manager"));
//        System.out.println(cDAO.getRoleById(1)); //checking if the Manager salary was updated

    }
}
