package com.revature;

import com.revature.utils.ConnectionUtil;

import java.sql.Connection;

public class Launcher {
    public static void main(String[] args) {

        try(Connection conn = ConnectionUtil.getConnection()) {


        }
    }
}
