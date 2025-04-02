/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompanny.simpleloggingexample;

import java.util.logging.Logger;

/**
 *
 * @author faaeq
 */
public class SimpleLoggingExample {
    
    private static final Logger logger = Logger.getLogger(SimpleLoggingExample.class.getName());

    public static void main(String[] args) {
        logger.info("This is an information message."); 
        logger.warning("This is a warning message."); 
        logger.severe("This is a severe message."); 
    }
}
