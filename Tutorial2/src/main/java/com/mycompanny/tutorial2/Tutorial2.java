/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompanny.tutorial2;

/**
 *
 * @author faaeq
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tutorial2 {
    public static void main(String[] args) {
        // 1. Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // 2. Create instances of UserValidator and UserDataStore
        UserValidator validator = new UserValidator();
        UserDataStore dataStore = new UserDataStore();

        // 3. Create a List to store Thread objects
        List<Thread> threadList = new ArrayList<>();

        // 4. Create a lock object for synchronization
        Object lock = new Object();

        // 5. Initialize a boolean variable to control the input loop
        boolean addMoreUsers = true;

        // 2. User Input Loop (while addMoreUsers)
        while (addMoreUsers) {
            // 7. Simulate concurrent user input (3 users at a time using for loop)
            for (int i = 0; i < 3; i++) {
                // 8. Prompt the user to enter a name
                System.out.print("Enter user " + (i + 1) + " name: ");
                String name = scanner.nextLine();

                // 10. Prompt the user to enter an age
                System.out.print("Enter user " + (i + 1) + " age: ");
                int age = scanner.nextInt();

                // 12. Create a UserProcessor object
                UserProcessor processor = new UserProcessor(validator, dataStore, lock, name, age);

                // 13. Create a Thread object with the UserProcessor object
                Thread thread = new Thread(processor);

                // 14. Add the thread to the thread list
                threadList.add(thread);

                // 15. Consume the newline character left by nextInt()
                scanner.nextLine();
            }

            // 16. Ask the user if they want to add more users
            System.out.print("Do you want to add more users? (yes/no): ");
            String response = scanner.nextLine();

            // 18. Update the loop control variable based on the response
            if (response.equalsIgnoreCase("no")) {
                addMoreUsers = false;
            }
        }

        // 3. Thread Execution (for Thread t : threadList)
        for (Thread t : threadList) {
            try {
                // 19. Start the thread
                t.start();
                // 20. Wait for the thread to finish (join)
                t.join();
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }
        }

        // 4. Displaying Users
        System.out.println("\nAll users stored:");
        for (User user : dataStore.getAllUsers()) {
            System.out.println(user);
        }

        // Close the scanner
        scanner.close();
    }
}
