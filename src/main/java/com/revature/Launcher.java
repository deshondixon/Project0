package com.revature;

import com.revature.utils.ConnectionUtil;
import io.javalin.Javalin;
import java.sql.Connection;
import java.sql.SQLException;

public class Launcher {
    public static void main(String[] args) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            System.out.println("CONNECTION SUCCESSFUL :)");
        } catch (SQLException e) {
            System.out.println("Connection Failed :(");
        }

        var app = Javalin.create().start(7070);

        SampleController controller = new SampleController();

        //-------CARDHOLDER----------

        app.get("/cardholders", controller::getAllCardholders);
        app.get("/cardholders/:id", controller::getCardholderById);
        app.post("/cardholders", controller::insertCardholder);
        app.put("/cardholders/:id", controller::updateCardholder);

        //-------PAYMENTS----------

        app.get("/payments", controller::getAllPayments);
        app.post("/payments", controller::insertPayment);
        app.put("/payments/:id", controller::updatePayment);
    }
}

