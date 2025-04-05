/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 *
 * @author faaeq
 */

public class MyHttpClient {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://localhost:8080/hello");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            // Print default request headers
            System.out.println("=== DEFAULT REQUEST HEADERS ===");
            Map<String, List<String>> defaultHeaders = con.getRequestProperties();
            printHeaders(defaultHeaders);  // Calls the client-side printHeaders

            // Set request method
            con.setRequestMethod("GET");

            // Get response code
            int responseCode = con.getResponseCode();
            System.out.println("\n=== SERVER RESPONSE ===");
            System.out.println("Response Code: " + responseCode);

            // Handle non-OK response
            if (responseCode != HttpURLConnection.HTTP_OK) {
                System.out.println("Error: Non-OK response received.");
                System.out.println("Response Message: " + con.getResponseMessage());
                // Optionally read error stream for more details
                try (BufferedReader errorReader = new BufferedReader(new InputStreamReader(con.getErrorStream()))) {
                    String errorLine;
                    StringBuilder errorContent = new StringBuilder();
                    while ((errorLine = errorReader.readLine()) != null) {
                        errorContent.append(errorLine).append("\n");
                    }
                    System.out.println("Error Content: \n" + errorContent);
                }
                return;  // Exit the program if the response is not OK
            }

            // Print response headers
            System.out.println("=== RESPONSE HEADERS ===");
            printHeaders(con.getHeaderFields());  // Get the response headers and print them

            // Read response body
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder responseContent = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                responseContent.append(inputLine).append("\n");
            }
            in.close();

            // Print response content
            System.out.println("\n=== RESPONSE CONTENT ===");
            System.out.println(responseContent.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printHeaders(Map<String, List<String>> headers) {
        headers.forEach((key, value) -> {
            System.out.println(key + ": " + String.join(", ", value));
        });
    }
}
