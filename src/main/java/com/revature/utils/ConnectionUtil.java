package com.revature.utils;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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

        Dotenv dotenv = Dotenv.load();

        String url = dotenv.get("DB_URL");
        String username = dotenv.get("DB_USERNAME");
        String password = dotenv.get("DB_PASSWORD");

        assert url != null;
        conn = DriverManager.getConnection(url, username, password);

        return conn;
    }
}
