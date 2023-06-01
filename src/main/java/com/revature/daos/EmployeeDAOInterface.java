package com.revature.daos;

import com.revature.models.Employee;
import com.revature.models.Role;

//Remember, the main reason I like Interfaces is for organization and clarity
//DAO methods are long. Imagine we have 20 DAO methods. An Interface is a quick way to see what methods we have.
public interface EmployeeDAOInterface {

    Employee getRoleByID(int id);

    boolean updateRoleSalary(int salary, String title);

}
