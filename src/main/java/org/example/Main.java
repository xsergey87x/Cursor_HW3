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

        Statement statement = null;
        var usersTeenagers = new ArrayList<>();
        var usersNameFinishO = new ArrayList<>();
        var usersWorkAge = new ArrayList<>();
        var usersNameWithA = new ArrayList<>();
        var usersFullAge = new ArrayList<>();

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/my_db", "root", "1234");
            statement = con.createStatement();

            var resultSetTeenagers = statement.executeQuery(SELECT_ALL_USERS_TEENAGERS);
            while (resultSetTeenagers.next()) {
                usersTeenagers.add(new User(resultSetTeenagers.getString("firstName"), resultSetTeenagers.getString("lastName"),
                        resultSetTeenagers.getInt("age"), resultSetTeenagers.getString("gender")));
            }

            var resultSetNameFinishO = statement.executeQuery(SELECT_ALL_USERS_NAME_FINISHED_O);
            while (resultSetNameFinishO.next()) {
                usersNameFinishO.add(new User(resultSetNameFinishO.getString("firstName"), resultSetNameFinishO.getString("lastName"),
                        resultSetNameFinishO.getInt("age"), resultSetNameFinishO.getString("gender")));
            }

            var resultSetWorkAge = statement.executeQuery(SELECT_ALL_USERS_WORK_AGE);
            while (resultSetWorkAge.next()) {
                User user = new User();
                user.setFirstName(resultSetWorkAge.getString("firstName"));
                user.setLastName(resultSetWorkAge.getString("lastName"));
                user.setAge(resultSetWorkAge.getInt("age"));
                user.setLastName(resultSetWorkAge.getString("gender"));
                usersWorkAge.add(user);
            }

            var resultSetNameWithA = statement.executeQuery(SELECT_ALL_USERS_NAME_WITH_A);
            while (resultSetNameWithA.next()) {
                User user = new User();
                user.setFirstName(resultSetNameWithA.getString("firstName"));
                user.setLastName(resultSetNameWithA.getString("lastName"));
                user.setAge(resultSetNameWithA.getInt("age"));
                user.setLastName(resultSetNameWithA.getString("gender"));
                usersNameWithA.add(user);
            }

            var resultSetFullAge = statement.executeQuery(SELECT_ALL_USERS_FULL_AGE);
            while (resultSetFullAge.next()) {
                User user = new User();
                user.setFirstName(resultSetFullAge.getString("firstName"));
                user.setLastName(resultSetFullAge.getString("lastName"));
                user.setAge(resultSetFullAge.getInt("age"));
                user.setLastName(resultSetFullAge.getString("gender"));
                usersNameWithA.add(user);
            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }


    }
}