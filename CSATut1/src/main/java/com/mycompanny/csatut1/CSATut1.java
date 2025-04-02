/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompanny.csatut1;

/**
 *
 * @author faaeq
 */
public class CSATut1 {

    public static void main(String[] args) {
        // Create objects of the Car class 
        Car car1 = new Car("Toyota", "Camry", 2020); 
        Car car2 = new Car("Honda", "Civic", 2021);
        
        // Access and modify object properties 
        car1.displayInfo(); // Display information about the first car 
        
        // Modify the year of the second car 
        car2.year = 2022; 
        
        // Display information about the second car after modification 
        car2.displayInfo(); 
        
    }
}
