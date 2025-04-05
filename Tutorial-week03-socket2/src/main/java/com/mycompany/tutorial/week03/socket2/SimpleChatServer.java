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

public class SimpleChatServer {
    public static void main(String[] args) {
        try {
            
            //Create a new instance of the Server Socket and pass port number
            final int PORT = 12345;
            ServerSocket serverSocket = new ServerSocket(PORT);
            
            //print out a message to say Server is running 
            System.out.println("Server is running on port " + PORT + "...");

            // Wait for a client to connect and accept the client request
            Socket clientSocket = serverSocket.accept();
            
            //print out a message to say client connected and get the IP ddress
            System.out.println("Client connected: " + clientSocket.getInetAddress());
            
            // Input stream to receive messages from the client
            InputStream input = clientSocket.getInputStream();

            // Output stream to send messages to the client
            OutputStream output = clientSocket.getOutputStream();
            
            //Create a buffer array with type byte, the size must be 1024
            byte[] buffer = new byte[1024];

            // Read messages from the client and print them
            int bytesRead = input.read(buffer);
            String message = new String(buffer, 0, bytesRead);
            System.out.println("Message from client: " + message);
            
            // Send a response back to the client
            String response = "Message received: " + message;
            output.write(response.getBytes());
            
            // Close the sockets
            clientSocket.close();
            serverSocket.close();
            
        //catch IO exception
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
