/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompanny.tutorial2;

/**
 *
 * @author faaeq
 */
public class Tutorial2 {
    public static void main(String[] args) {
        // Create instances of the validator, data store, and synchronization lock
        UserValidator validator = new UserValidator();
        UserDataStore dataStore = new UserDataStore();
        Object lock = new Object();

        // Create UserProcessor threads for two different users
        UserProcessor processor1 = new UserProcessor(validator, dataStore, lock, "Alice", 25);
        UserProcessor processor2 = new UserProcessor(validator, dataStore, lock, "Bob", 30);

        // Create threads for each processor
        Thread thread1 = new Thread(processor1);
        Thread thread2 = new Thread(processor2);

        // Start the threads
        thread1.start();
        thread2.start();

        // Wait for threads to finish
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print out all users in the data store
        System.out.println("\nAll users stored:");
        for (User user : dataStore.getAllUsers()) {
            System.out.println(user);
        }
    }
}
