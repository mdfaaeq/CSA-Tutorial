/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompanny.example;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author faaeq
 */
 
public class Example { 
    private static final Logger logger = Logger.getLogger(Example.class.getName()); 
 
    public static void main(String[] args) { 
        // Create a console handler 
        ConsoleHandler consoleHandler = new ConsoleHandler(); 
         
        // Set the logging level for the handler 
        consoleHandler.setLevel(Level.ALL); 
 
        // Add the handler to the logger 
        logger.addHandler(consoleHandler); 
 
        // Log messages 
        logger.info("This is an informational message."); 
        logger.warning("This is a warning message."); 
        logger.severe("This is a severe message."); 
    } 
} 