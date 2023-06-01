package com.revature.daos;

import com.revature.models.Role;

public interface RoleDAOInterface {
    Role getRoleByID(int id);

    boolean updateRoleSalary(int salary, String title);

}
