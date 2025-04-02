/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompanny.csatut1;

/**
 *
 * @author faaeq
 */
// Define a class called "Car"
public class Car {
    
    // Fields or attributes 
    String make;
    String model;
    int year;
    
    // Constructor to initialize the object 
    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }
    
    // Method to display information about the car 
    public void displayInfo(){
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
    }
}
