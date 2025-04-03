/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompanny.tutorial2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author faaeq
 */

public class UserDataStore {
    private List<User> userList;

    // Constructor
    public UserDataStore() {
        userList = new ArrayList<>();
    }

    // Method to store user data (for example purposes)
    public void storeUser(String name, int age) {
        User newUser = new User(name, age);
        userList.add(newUser);
    }

    // Method to add a User object to the list
    public void addUser(User user) {
        userList.add(user);
    }

    // Method to get a copy of the user list
    public List<User> getAllUsers() {
        return new ArrayList<>(userList); // Return a copy to prevent external modification
    }
}

