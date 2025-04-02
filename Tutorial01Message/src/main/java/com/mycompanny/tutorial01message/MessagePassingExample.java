/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompanny.tutorial01message;

/**
 *
 * @author faaeq
 */
public class MessagePassingExample {
    public static void main(String[] args) {
        Sender sender = new Sender();
        Receiver receiver = new Receiver();

        Message message = sender.createMessage("Hello, this is a test message!");
        sender.sendMessage(message, receiver);
    }
}

