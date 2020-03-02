package com.example.tattooguestspot.dao;

import android.util.Log;

import com.example.tattooguestspot.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private static List<User> userList = new ArrayList<>();
    private static int userId = 0;

    public void create(User user) {
        userList.add(user);
        user.setId(userId);
        userId++;
    }

    public User isValidUser(String userName) {

        User validUser = null;

        for (User u : userList) {
            if (u.getUserName().equals(userName)) {
                validUser = u;
                Log.i("User", "isValidUser: " + validUser.getUserName() + validUser.getPassword());
                return validUser;
            }

        }
        return null;
    }
}
