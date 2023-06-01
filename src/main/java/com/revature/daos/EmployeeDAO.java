package com.revature.daos;

import com.revature.models.Employee;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAO implements EmployeeDAOInterface {
    @Override
    public ArrayList<Employee> getAllEmployees() {
        return null;
    }

    @Override
    public Employee insertEmployee(Employee emp) {

        try(Connection conn = ConnectionUtil.getConnection()) {

            String sql = "INSERT INTO employees (first_name, last_name, role_id_fk)";

        } catch(SQLException e) {
            System.out.println("Insert employee failed!");
            e.printStackTrace();
        }
        return null;
    }
}
