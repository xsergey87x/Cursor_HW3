package org.example;

import org.example.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static org.example.utils.SqlQueries.*;

public class Main {
    public static void main(String[] args) {

        var usersTeenagers = new ArrayList<>();
        var usersNameFinishO = new ArrayList<>();
        var usersWorkAge = new ArrayList<>();
        var usersNameWithA = new ArrayList<>();
        var usersFullAge = new ArrayList<>();

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/my_db", "root", "1234");
            Statement statement = con.createStatement();

            var resultSetTeenagers = statement.executeQuery(SELECT_ALL_USERS_TEENAGERS);
            while (resultSetTeenagers.next()) {
                usersTeenagers.add(new User(resultSetTeenagers.getString("first_name"), resultSetTeenagers.getString("last_name"),
                        resultSetTeenagers.getInt("age"), resultSetTeenagers.getString("gender")));
            }

            var resultSetNameFinishO = statement.executeQuery(SELECT_ALL_USERS_NAME_FINISHED_O);
            while (resultSetNameFinishO.next()) {
                usersNameFinishO.add(new User(resultSetNameFinishO.getString("first_name"), resultSetNameFinishO.getString("last_name"),
                        resultSetNameFinishO.getInt("age"), resultSetNameFinishO.getString("gender")));
            }

            var resultSetWorkAge = statement.executeQuery(SELECT_ALL_USERS_WORK_AGE);
            while (resultSetWorkAge.next()) {
                usersWorkAge.add(new User(resultSetWorkAge.getString("first_name"), resultSetWorkAge.getString("last_name"),
                        resultSetWorkAge.getInt("age"), resultSetWorkAge.getString("gender")));
            }

            var resultSetNameWithA = statement.executeQuery(SELECT_ALL_USERS_NAME_WITH_A);
            while (resultSetNameWithA.next()) {
                usersNameWithA.add(new User(resultSetNameWithA.getString("first_name"), resultSetNameWithA.getString("last_name"),
                        resultSetNameWithA.getInt("age"), resultSetNameWithA.getString("gender")));
            }

            var resultSetFullAge = statement.executeQuery(SELECT_ALL_USERS_FULL_AGE);
            while (resultSetFullAge.next()) {
                usersFullAge.add(new User(resultSetFullAge.getString("first_name"), resultSetFullAge.getString("last_name"),
                        resultSetFullAge.getInt("age"), resultSetFullAge.getString("gender")));
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        printUser(usersTeenagers);
        printUser(usersNameFinishO);
        printUser(usersWorkAge);
        printUser(usersNameWithA);
        printUser(usersFullAge);
    }

    public static void printUser(ArrayList<Object> user) {
        for (Object person : user) {
            System.out.println(person.toString());
        }
        System.out.println("---------------------------------");
    }
}