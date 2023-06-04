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

        //UPDATE
//        System.out.println(CDAO.updateRoleSalary(500000, "Manager"));
//        System.out.println(rDAO.getRoleById(1)); //checking if the Manager salary was updated
    }
}
