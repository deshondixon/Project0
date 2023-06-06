package com.revature.daos;

import com.revature.models.Cardholder;
import com.revature.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;

public class CardholderDAO implements CardholderDAOInterface {


    //SELECT ALL
    @Override
    public ArrayList<Cardholder> getAllCardholder() {

        try (Connection conn = ConnectionUtil.getConnection()) {

            String sql = "SELECT * FROM cardholder";
            Statement s = conn.createStatement();

            ResultSet rs = s.executeQuery(sql);

            ArrayList<Cardholder> cardholderList = new ArrayList<>();


            while (rs.next()) {
                Cardholder cardholder = new Cardholder(
                        rs.getInt("cardholder_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name")
                );
                cardholderList.add(cardholder);
            }
            return cardholderList;
        } catch (SQLException e) {
            System.out.println("Failed to get all employees");
            e.printStackTrace();
        }
        return null;
    }

    //SELECT BY ID
    @Override
    public Cardholder getCardholderById(int id) {

        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM cardholder WHERE cardholder_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Cardholder(
                        rs.getInt("cardholder_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name")
                );
            }
        } catch (SQLException e) {
            System.out.println("error getting Cardholder");
            e.printStackTrace();
        }
        return null;
    }


    //INSERT
    @Override
    public Cardholder insertCardholder(Cardholder ch) {

        try (Connection conn = ConnectionUtil.getConnection()) {

            String sql = "INSERT INTO cardholder (first_name, last_name) VALUES (?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ch.getFirstName());
            ps.setString(2, ch.getLastName());

            ps.executeUpdate();

            return ch;

        } catch (SQLException e) {
            System.out.println("Insert cardholder failed!");
            e.printStackTrace();
        }
        return null;
    }

    //UPDATE
    @Override
    public boolean updateCardholder(String first_name, String last_name, int id) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "UPDATE cardholder SET first_name = ?, last_name = ? WHERE cardholder_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, first_name);
            ps.setString(2, last_name);
            ps.setInt(3, id);

            ps.executeUpdate();

            return true;
        } catch (SQLException e) {
            System.out.println("Update failed!!");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteCardholder(int id) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "DELETE FROM cardholder WHERE cardholder_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Delete failed!");
            e.printStackTrace();
        }
        return false;
    }


}
