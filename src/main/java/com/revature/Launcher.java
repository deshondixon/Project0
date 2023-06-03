package com.revature;

import com.revature.daos.EmployeeDAO;
import com.revature.daos.RoleDAO;
import com.revature.models.Employee;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class Launcher {
    public static void main(String[] args) {

        /*This is a try-with-resources block
        A resource (in this case, a DB connection) is opened within the parenthesis
        Another benefit is that the resource will close for us when the block completes,
        This is helpful for code cleanup and preventing memory leaks*/
        try (Connection conn = ConnectionUtil.getConnection()) {
            System.out.println("Connection Successful");
        } catch (SQLException e) {
            System.out.println("Connection Failed");
        }

        RoleDAO roleDAO = new RoleDAO();

        System.out.println(roleDAO.getRoleByID(2));

        System.out.println(roleDAO.updateRoleSalary(500000, "Manager"));
        System.out.println(roleDAO.getRoleByID(1));

        EmployeeDAO eDAO = new EmployeeDAO();

        Employee deshon = new Employee("DeShon", "Dixon", 3);

        System.out.println(eDAO.insertEmployee(deshon));

        ArrayList<Employee> employeeList = eDAO.getAllEmployees();

        for (Employee e : employeeList) {
            System.out.println(e);
        }

        System.out.println(eDAO.deleteEmployee(5));


    }
}
