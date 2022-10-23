package org.example;

import org.example.jdbc.UserDaoJdbc;
import org.example.jdbc.UserDaoJdbcImpl;

import static org.example.utils.Print.printAllUser;

public class Main {
    public static void main(String[] args) {

        UserDaoJdbc userDao = new UserDaoJdbcImpl();

        printAllUser(userDao.getAllTeenagersUsers(), userDao.getAllUsersWithNameEndsO(), userDao.getAllUsersFullAge(),
                userDao.getAllUsersWithNameContainA(), userDao.getAllUsersWorkAge());
    }
}