package com.revature.daos;

import com.revature.models.Role;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class RoleDAO implements RoleDAOInterface {

    @Override
    public Role getRoleByID(int id) {

        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM roles WHERE role_id = ?";

        } catch (SQLException e) {
            System.out.println("error getting Role");
            e.printStackTrace();
        }
        return null;
    }
}

