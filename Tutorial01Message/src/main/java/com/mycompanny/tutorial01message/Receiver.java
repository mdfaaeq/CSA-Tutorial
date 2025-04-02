/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompanny.tutorial01message;

/**
 *
 * @author faaeq
 */
public class Receiver {
    
    public void receiveMessage(Message message) {
        System.out.println("Message received: " + message.getContent());
    }
    
}
