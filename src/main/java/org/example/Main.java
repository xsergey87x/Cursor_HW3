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

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/my_db","root","1234");
            statement = con.createStatement();

        var resultSetTeenagers = statement.executeQuery(SELECT_ALL_USERS_TEENAGERS);
            while (resultSetTeenagers.next())
            {
                User user = new User();
                user.setFirstName(resultSetTeenagers.getString("firstName"));
                user.setLastName(resultSetTeenagers.getString("lastName"));
                user.setAge(resultSetTeenagers.getInt("age"));
                user.setLastName(resultSetTeenagers.getString("gender"));
                usersTeenagers.add(user);
            }

         var resultSetNameFinishO = statement.executeQuery(SELECT_ALL_USERS_NAME_FINISHED_O);
            while (resultSetNameFinishO.next())
            {
                User user = new User();
                user.setFirstName(resultSetNameFinishO.getString("firstName"));
                user.setLastName(resultSetNameFinishO.getString("lastName"));
                user.setAge(resultSetNameFinishO.getInt("age"));
                user.setLastName(resultSetNameFinishO.getString("gender"));
                usersNameFinishO.add(user);
            }

            var resultSetWorkAge = statement.executeQuery(SELECT_ALL_USERS_WORK_AGE);
            while (resultSetWorkAge.next())
            {
                User user = new User();
                user.setFirstName(resultSetWorkAge.getString("firstName"));
                user.setLastName(resultSetWorkAge.getString("lastName"));
                user.setAge(resultSetWorkAge.getInt("age"));
                user.setLastName(resultSetWorkAge.getString("gender"));
                usersWorkAge.add(user);
            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }


    }
}