/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.examplehttpsocket1;

/* Please import necessary classes for input and output operations */


/* Please import necessary classes for networking operations */


/* Please import necessary classes for data structures like Map and Set */


public class Server {

    /* Please create a ServerSocket to listen for incoming client connections */
    

    /* Please create a Map to store client usernames and their corresponding PrintWriter objects */
    

    
    private Set<String> usernames = new HashSet<>();

    public Server(int port) {
        try {
            /* Please create a ServerSocket to listen on the specified port */
            

            /* Please print a message to indicate the server has started */
           

            while (true) {
                /* Please accept incoming client connections */
                

                /* Please create and start a new thread to handle the client */
               
            }
        } catch (IOException e) {
           
            e.printStackTrace();
        }
    }

    private void broadcast(String message, String sender) {
        for (PrintWriter client : clients.values()) {
            client.println(sender + ": " + message);
        }
    }

    private void sendPrivateMessage(String message, String sender, String recipient) {
        if (clients.containsKey(recipient)) {

            clients.get(recipient).println(sender + " (private): " + message);
        } else {

            clients.get(sender).println("User " + recipient + " not found.");
        }
    }

    private void updateUserList() {

        StringBuilder userList = new StringBuilder("USERLIST:");

        for (String username : usernames) {

            userList.append(username).append(",");
        }

        if (userList.length() > 9) {
            userList.deleteCharAt(userList.length() - 1);
        }

        for (PrintWriter client : clients.values()) {

            client.println(userList.toString());
        }
    }

    private class ClientHandler extends Thread {

        /* Please create a Socket for the connected client */
       

        /* Please create a BufferedReader to read input from the client */
       

        /* Please create a PrintWriter to send output to the client */
       

        /* Please create a variable to store the username of the connected client */
       

        public ClientHandler(Socket socket) {

            this.clientSocket = socket;
        }

        public void run() {
            try {
                /* Please initialize the BufferedReader to read input from the client */
                

                /* Please initialize the PrintWriter to send output to the client */
                

                /* Please read the username from the client */
                

                /* Please check if the username is invalid or already taken */
               
                    /* Please send an error message if the username is invalid */
                    

                    /* Please close the client socket */
                    
                    return;
                }

                usernames.add(username);

                clients.put(username, out);

                updateUserList();

                broadcast(username + " has joined the chat.", "Server");

                String message;
                while ((message = in.readLine()) != null) {
                    if (message.equals("EXIT")) {
                        
                        break;
                    } else if (message.startsWith("PRIVATE:")) {
                       
                        String[] parts = message.substring("PRIVATE:".length()).split(":", 2);
                        String recipient = parts[0];
                        String privateMessage = parts[1];

                       
                        sendPrivateMessage(privateMessage, username, recipient);
                    } else {
                       
                        broadcast(message, username);
                    }
                }

                usernames.remove(username);

                clients.remove(username);

                updateUserList();

                /* Please broadcast a message that the user has left */
               

                /* Please close the client socket */
                

            } catch (IOException e) {

                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        new Server(12345);
    }
}
