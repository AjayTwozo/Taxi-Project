package com.TaxiProject.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public Connection getConnection() {
        final String URL = "jdbc:postgresql://localhost:5432/postgres";
        final String userName = "postgres";
        final String password = "R@valaddu98";
        Connection connection = null;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, userName, password);
            //System.out.println("Connection Successful!");
        } catch (SQLException | ClassNotFoundException exception) {
            System.out.println("Error in connecting to the DB!");
            exception.printStackTrace();
        }
        return connection;
    }
}