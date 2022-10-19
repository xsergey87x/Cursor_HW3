package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {

        Statement statement = null;

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/my_db","root","1234");
            statement = con.createStatement();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }


    }
}