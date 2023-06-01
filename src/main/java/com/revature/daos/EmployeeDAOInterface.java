package com.revature.daos;

import com.revature.models.Employee;
import com.revature.models.Role;

import java.lang.reflect.Array;
import java.util.ArrayList;

//Remember, the main reason I like Interfaces is for organization and clarity
//DAO methods are long. Imagine we have 20 DAO methods. An Interface is a quick way to see what methods we have.
public interface EmployeeDAOInterface {

    //A method to SELECT all employees
    ArrayList<Employee> getAllEmployees();

    //A method to INSERT an employee
    Employee insertEmployee();

    //A method to DELETE an employee
}
