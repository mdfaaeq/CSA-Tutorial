/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tutorial.week03.socket2;

//import necessary libraries
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.*;

public class SimpleChatServer {
    private static final Logger logger = Logger.getLogger(SimpleChatServer.class.getName());
    
    static {
        try {
            FileHandler fileHandler = new FileHandler("logs.txt", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
            logger.setUseParentHandlers(false);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to set up file handler for logger", e);
        }
    }
    
    public static void main(String[] args) {
        try {
            
            //Create a new instance of the Server Socket and pass port number
            final int PORT = 12345;
            ServerSocket serverSocket = new ServerSocket(PORT);
            
            //print out a message to say Server is running 
            logger.log(Level.INFO, "Server is running on port {0}...", PORT);

            // Wait for a client to connect and accept the client request
            Socket clientSocket = serverSocket.accept();
            
            //print out a message to say client connected and get the IP ddress
            logger.log(Level.INFO, "Client connected: {0}", clientSocket.getInetAddress());
            
            // Input stream to receive messages from the client
            InputStream input = clientSocket.getInputStream();

            // Output stream to send messages to the client
            OutputStream output = clientSocket.getOutputStream();
            
            //Create a buffer array with type byte, the size must be 1024
            byte[] buffer = new byte[1024];

            // Read messages from the client and print them
            int bytesRead;

            while ((bytesRead = input.read(buffer)) != -1) {
                String message = new String(buffer, 0, bytesRead);
                logger.log(Level.INFO, "Received from client: {0}", message);
                System.out.println("Client: " + message);

                String responseMessage = "Server received your message: " + message;
                output.write(responseMessage.getBytes());
                logger.log(Level.INFO, "Sent to client: {0}", responseMessage);
            }
            
            // Close the sockets
            clientSocket.close();
            serverSocket.close();
            
        //catch IO exception
        } catch (IOException e){
            logger.log(Level.SEVERE, "Server exception occurred", e);
        }
    }
}
