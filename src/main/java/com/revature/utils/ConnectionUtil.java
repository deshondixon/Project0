package com.revature.utils;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
    private static Connection conn = null;

    private ConnectionUtil() {

    }

    public static Connection getConnection() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            System.out.println("Using a previously created connection");
            return conn;
        }

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("problem occurred locating driver");
        }

        Properties prop = new Properties();

        String url = "";
        String username = "";
        String password = "";

        try {
            prop.load(new FileReader("src/main/resources/application.properties"));

            url = prop.getProperty("url");
            username = prop.getProperty("username");
            password = prop.getProperty("password");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        conn = DriverManager.getConnection(url, username, password);


        return conn;

    }

}