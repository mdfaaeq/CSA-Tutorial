/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompanny.tutorial2;

/**
 *
 * @author faaeq
 */
public class UserProcessor implements Runnable {
    private UserValidator validator;
    private UserDataStore dataStore;
    private Object lock;
    private String name;
    private int age;

    // Constructor
    public UserProcessor(UserValidator validator, UserDataStore dataStore, Object lock, String name, int age) {
        this.validator = validator;
        this.dataStore = dataStore;
        this.lock = lock;
        this.name = name;
        this.age = age;
    }

    @Override
    public void run() {
        if (validator.isValidAge(age)) {
            synchronized (lock) {
                dataStore.storeUser(name, age);
                System.out.println("User " + name + " (age: " + age + ") stored successfully.");
            }
        } else {
            System.out.println("Invalid age for user: " + name);
        }
    }
}

