package com.revature.daos;

import com.revature.models.Role;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RoleDAO implements RoleDAOInterface {

    @Override
    public Role getRoleByID(int id) {

        try (Connection conn = ConnectionUtil.getConnection()) {

            /*We need a String that holds the SQL command we want to run on the DB.
            This String has a wildcard/parameter/variable for the role_id (the ?)
            We have to take the user-inputted role id and put it into this wildcard*/
            String sql = "SELECT * FROM roles WHERE role_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

        } catch (SQLException e) {
            System.out.println("error getting Role");
            e.printStackTrace();
        }
        return null;
    }
}

