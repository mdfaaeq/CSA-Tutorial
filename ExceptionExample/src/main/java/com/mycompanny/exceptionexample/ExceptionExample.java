/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompanny.exceptionexample;

/**
 *
 * @author faaeq
 */
import java.util.Scanner;

public class ExceptionExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Example 1: ArithmeticException
        try {
            System.out.println("Enter a number: ");
            int num1 = scanner.nextInt();
            System.out.println("Enter another number: ");
            int num2 = scanner.nextInt();

            int result = num1 / num2;
            System.out.println("Result of division: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred.");
            e.printStackTrace();
        }

        // Example 2: ArrayIndexOutOfBoundsException
        try {
            int[] numbers = {1, 2, 3, 4, 5};
            System.out.println("Enter an index to get the corresponding number from the array: ");
            int index = scanner.nextInt();

            int value = numbers[index];
            System.out.println("Value at index " + index + ": " + value);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Index out of bounds. Please enter a valid index.");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred.");
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}

