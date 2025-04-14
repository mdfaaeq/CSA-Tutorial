/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.jaxrsexample;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;


@Path("/hello")


public class HelloWorldResource {

 
    private static Map<Integer, String> users = new HashMap<>();

    // Add some initial users to the map
    static {
        users.put(1, "John Doe");
        users.put(2, "Jane Smith");
        users.put(3, "Bob Johnson");
    }

    @GET
    @Path("/user/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserById(@PathParam("userId") int userId) {
        // Check if the user exists
        if (users.containsKey(userId)) {
            return new User(userId, users.get(userId));
        } else {
            return new User(userId, "User not found");
        }
    }

    @GET
    @Path("/allUsers")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<Integer, String> getAllUsers() {
        return users;
    }

}
