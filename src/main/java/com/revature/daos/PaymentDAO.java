package com.revature.daos;

import com.revature.models.Payment;
import com.revature.utils.ConnectionUtil;
import java.util.ArrayList;
import java.sql.*;

public class PaymentDAO implements PaymentDAOInterface{

    //GET ALL PAYMENTS
    @Override
    public ArrayList<Payment> getAllPayments() {

        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "SELECT * FROM payment";
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);

            ArrayList<Payment> paymentList = new ArrayList<>();

            CardholderDAO cDAO = new CardholderDAO();

            while(rs.next()){
                Payment payment = new Payment(
                        rs.getInt("payment_id"),
                        rs.getString("bill"),
                        rs.getString("due_date"),
                        cDAO.getCardholderById(rs.getInt("cardholder_id_fk")).getCardholder_id()
                );
                paymentList.add(payment);
            }
            return paymentList;

        } catch(SQLException e){
            System.out.println("Failed to get all payment");
            e.printStackTrace();
        }
        return null;
    }

    //INSERT
    @Override
    public Payment insertPayment(Payment pay) {

        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "INSERT INTO payment (bill, due_date, cardholder_id_fk) VALUES (?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, pay.getBill());
            ps.setString(2, pay.getDueDate());
            ps.setInt(3, pay.getCardholder_id_fk());

            ps.executeUpdate();

            return pay;

        } catch(SQLException e){
            System.out.println("Insert payment failed!");
            e.printStackTrace();
        }
        return null;
    }
}
