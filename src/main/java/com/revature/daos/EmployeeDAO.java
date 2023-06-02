package com.revature.daos;

import com.revature.models.Employee;
import com.revature.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;

public class EmployeeDAO implements EmployeeDAOInterface {
    @Override
    public ArrayList<Employee> getAllEmployees() {


        try (Connection conn = ConnectionUtil.getConnection()) {

            String sql = "SELECT * FROM employees";

            Statement s = conn.createStatement();

            ResultSet rs = s.executeQuery(sql);

            ArrayList<Employee> employeeList = new ArrayList<>();

            RoleDAO rDAO = new RoleDAO();

            while (rs.next()) {
                Employee employee = new Employee(
                        rs.getInt("employee_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rDAO.getRoleByID(rs.getInt("role_id_fk"))
                );

                employeeList.add(employee);

            }

            return employeeList;

        } catch (SQLException e) {
            System.out.println("Failed to get all employees!");
            e.printStackTrace(); //tells the user what exactly went wrong
        }

        return null;
    }

    @Override
    public Employee insertEmployee(Employee emp) {

        try (Connection conn = ConnectionUtil.getConnection()) {

            String sql = "INSERT INTO employees (first_name, last_name, role_id_fk) VALUES (?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, emp.getFirst_name());
            ps.setString(2, emp.getLast_name());
            ps.setInt(3, emp.getRole_id_fk());

            ps.executeUpdate();

            return emp;

        } catch (SQLException e) {
            System.out.println("Insert employee failed!");
            e.printStackTrace(); //tells the user what exactly went wrong
        }
        return null;
    }

    @Override
    public boolean deleteEmployee(int id) {
        try (Connection conn = ConnectionUtil.getConnection()) {

            String sql = "DELETE FROM employees WHERE employee_id = ?"; // Corrected SQL query
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id); // Corrected index

            int rowsDeleted = ps.executeUpdate();

            return rowsDeleted > 0; // return true if one or more rows were deleted

        } catch (SQLException e) {
            System.out.println("Delete employee failed!");
            e.printStackTrace(); // tells the user what exactly went wrong
        }
        return false; // return false if deletion failed
    }


}
