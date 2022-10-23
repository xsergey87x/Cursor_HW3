package org.example.utils;
import org.example.model.User;

import java.util.ArrayList;

public class Print {

    public static void printUser(ArrayList<User> user) {
        for (User person : user) {
            System.out.println(person.toString());
        }
        System.out.println("---------------------------------");
    }
    public static void printAllUser(ArrayList<User> user1, ArrayList<User> user2, ArrayList<User> user3, ArrayList<User> user4, ArrayList<User> user5) {
              printUser(user1);
              printUser(user2);
              printUser(user3);
              printUser(user4);
              printUser(user5);
    }
}
