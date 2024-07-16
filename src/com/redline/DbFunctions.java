package com.redline;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbFunctions {
    public Connection connectToDB(String dbname, String user, String pass) {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname + "?serverTimezone=Europe/Moscow&useSSL=false", user, pass);
            if (conn != null) {
                System.out.println("Connection Success");
            } else {
                System.out.println("Connection failed");
            }
        } catch (Exception ex) {
            System.out.println("Error");
            System.out.println(ex);
        }



        return conn;
    }
}
