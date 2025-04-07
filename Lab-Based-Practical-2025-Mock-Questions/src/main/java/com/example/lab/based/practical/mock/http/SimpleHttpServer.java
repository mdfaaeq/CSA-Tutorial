/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.lab.based.practical.mock.http;

/*
 * ----------------
 * Please import necessary libraries
 * ----------------
*/
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

/*
 * ----------------
 * Please define a class named 'SimpleHttpServer' to encapsulate the HTTP server functionality.
 * ----------------
*/
public class SimpleHttpServer{

    /*
     * ----------------
     * Please define the main method, the entry point of the application.
     * This method sets up and starts the HTTP server.
     * ----------------
    */
    public static void main(String[] args) throws IOException {

        /*
         * ----------------
         * Please create an HttpServer instance called server that listens on port 8080. Set the backlog to 0
         * Use try-with-resources to ensure the server is closed properly.
         * ----------------
        */
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        
        try {
            
            /*
             * ----------------
             * Create a context for "/myendpoint" and handle it with MyHandler.
             * ----------------
            */
            server.createContext("/myendpoint", new MyHandler());
            
            /*
             * ----------------
             * Set the server's executor to null (no thread pool).
             * ----------------
            */
            server.setExecutor(null);

            /*
             * ----------------
             * Start the server.
             * print "Server started on port 8080"
             * ----------------
            */
            server.start();
            System.out.println("Server started on port 8080");
        } catch (Exception e) {
             e.printStackTrace();
        }
            
    }

    /*
     * ----------------
     * Define a static inner class 'MyHandler' to handle HTTP requests to '/myendpoint'. 
     * This class implements HttpHandler 
     * ----------------
    */
    static class MyHandler implements HttpHandler{
        
        /*
         * -----------------------
         * Please override the handle method which accepts HttpExchange object called exchange which throws io exception
         * -----------------------
        */
        @Override
        public void handle(HttpExchange exchange) throws IOException{

            /*
             * ----------------
             * please get request method using exchange object and store it insdie a string variable called string
             * please get the request URI and the related path using exchange object and store it in a string variable called path
             * ----------------
            */
            String string = exchange.getRequestMethod();
            String path = exchange.getRequestURI().getPath();

            /*
             * ----------------
             * if the endpoint equals path
                * invoke/call the sendResponse method and pass necessary arguments. 
                * then use return keyword
             * ----------------
            */
            if ("/myendpoint".equals(path)) {
                sendResponse(exchange, "Endpoint reached ", 200);
                return;
            }
           
            /*
             * ---------------
             * check if the request method is "GET"
             * ---------------
            */
            
            if ("GET".equals(string)){
                handleGetRequest(exchange);
            /*
            * ------------------
            * otherwise check if the request method is "POST"
            * ------------------
            */
            } else if ("POST".equals(string)){

                /*
                 * ------------------
                 * define s atring varibale called response and store a message like "This is a POST request to /myendpoint"
                 * call sendResponse method and provide necessary arguments
                 * ------------------
                */
                String response = "This is a POST request to /myendpoint";
                sendResponse(exchange, response, 200);
            }

            /*
            * ----------------------
            * other wise Handle unsupported methods by calling sendResponse method and pass necessary arguments 
            * ----------------------
            */
            else { 
                sendResponse(exchange, "Method not supppoerted ", 405);
            }
        }

        /*
         * -------------------------
         * Please define a private void method called handleGetRequest which accepts an object of the HttpExhcnage called exchange, 
           throwing io exception
         * -------------------------
        */
        private void handleGetRequest(HttpExchange exchange) throws IOException{

            /*
             * -------------
             * Please define a string variable called response and include this message: "This is a GET request to /myendpoint"
             * -------------
            */
            String response = "This is a GET request to /myendpoint";
            
            /*
             * -------------------
             * Please invoke sendResponse methos and pass necessary arguments
             * -------------------
            */
            sendResponse(exchange, response, 200);
            
        }

        /*
         * -------------------------
         * Please define a private void method called sendResponse and pass these arguments: 
           HttpExhange object: exchange, a string varibale reponse, an integer varibale statusCode
         * -------------------------
        */
        private void sendResponse(HttpExchange exchange, String response, int statusCode)throws IOException{
        
            /*
             * -------------
             * Please get response headers using exchange object and Set the "Content-Type" header to "text/plain".
             * -------------
            */
            exchange.getResponseHeaders().set("Content-Type", "text/plain");

             /*
             * ------------------
             * Please send response headers using exchange object and pass response code, 
               and convert the reponse to bytes and get the length of that
             * ------------------
            */
            exchange.sendResponseHeaders(statusCode, response.getBytes().length);
            
            /*
             * --------------------
             * Please define a try block and inside it create an object of the OutputStream called os 
               and get the response body using exchange object
             * Send the response using os object and pass reponse as its argument by converting it to bytes.
             * --------------------
            */
            try (OutputStream os = exchange.getResponseBody()){
                os.write(response.getBytes());
            } catch (Exception e) {
            }
            
        }
    }
}