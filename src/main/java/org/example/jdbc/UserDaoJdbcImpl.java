package org.example.jdbc;

import org.example.model.User;

import java.sql.*;
import java.util.ArrayList;

import static org.example.utils.SqlConstant.*;
import static org.example.utils.SqlQueries.*;

public class UserDaoJdbcImpl implements UserDaoJdbc {


    @Override
    public ArrayList<User> getAllTeenagersUsers() {
        return getUsersFromDB(SELECT_ALL_USERS_TEENAGERS);
    }

    @Override
    public ArrayList<User> getAllUsersWithNameEndsO() {
        return getUsersFromDB(SELECT_ALL_USERS_NAME_FINISHED_O);
    }

    @Override
    public ArrayList<User> getAllUsersWorkAge() {
        return getUsersFromDB(SELECT_ALL_USERS_WORK_AGE);
    }

    @Override
    public ArrayList<User> getAllUsersWithNameContainA() {
        return getUsersFromDB(SELECT_ALL_USERS_NAME_WITH_A);
    }

    @Override
    public ArrayList<User> getAllUsersFullAge() {
        return getUsersFromDB(SELECT_ALL_USERS_FULL_AGE);
    }

    private ArrayList<User> getUsersFromDB(String query) {
        var listOfUsers = new ArrayList<User>();

        try (Connection con = DriverManager.getConnection(URL, BASE_USER, PASSWORD); Statement statement = con.createStatement();) {
            ResultSet resultSetTeenagers = statement.executeQuery(query);
            while (resultSetTeenagers.next()) {
                listOfUsers.add(new User(resultSetTeenagers.getString("first_name"), resultSetTeenagers.getString("last_name"),
                        resultSetTeenagers.getInt("age"), resultSetTeenagers.getString("gender")));
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return listOfUsers;
    }

}
