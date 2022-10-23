package org.example.jdbc;
import org.example.model.User;
import java.util.ArrayList;

public interface UserDaoJdbc {

    ArrayList<User> getAllTeenagersUsers();
    ArrayList<User> getAllUsersWithNameEndsO();
    ArrayList<User> getAllUsersWorkAge();
    ArrayList<User> getAllUsersWithNameContainA();
    ArrayList<User> getAllUsersFullAge();
}
