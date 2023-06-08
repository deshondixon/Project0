package com.revature.utils;


import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class ConnectionUtil {
    public static Connection getConnection() throws SQLException {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("problem occurred locating driver");
        }
        String url = "";
        String username = "";
        String password = "";

        try {
        Properties prop = new Properties();}
        prop.load(new FileReader("src/main/resources/application.properties"));

        return DriverManager.getConnection(url, username, password);
    }
}