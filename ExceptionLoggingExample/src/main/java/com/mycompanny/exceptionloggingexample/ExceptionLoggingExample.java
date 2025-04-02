/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompanny.exceptionloggingexample;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author faaeq
 */
public class ExceptionLoggingExample {

    private static final Logger logger = Logger.getLogger(ExceptionLoggingExample.class.getName()); 
 
    public static void main(String[] args) { 
        try { 
            // Some code that may throw an exception 
            throw new RuntimeException("This is a sample exception."); 
        } catch (RuntimeException e) { 
            logger.log(Level.SEVERE, "An exception occurred: {0}", e.getMessage()); 
            logger.severe("Stack trace: "); 
            for (StackTraceElement element : e.getStackTrace()) { 
                logger.severe(element.toString()); 
            } 
        } 
    } 
}
