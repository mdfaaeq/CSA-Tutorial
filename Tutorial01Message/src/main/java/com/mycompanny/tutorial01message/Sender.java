/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompanny.tutorial01message;

/**
 *
 * @author faaeq
 */
public class Sender {
    
    public Message createMessage(String content) {
        System.out.println("Message created: " + content);
        return new Message(content);
    }
    
    public void sendMessage(Message message, Receiver receiver) {
        System.out.println("Sending message to receiver...");
        receiver.receiveMessage(message);
    }
}
