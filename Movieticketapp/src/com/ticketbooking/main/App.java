package com.ticketbooking.main;

import com.ticketbooking.service.MovieShowService;

import java.util.Scanner;

public class App {

    private static final String USERNAME = "Anurag";  // Replace with your desired username
    private static final String PASSWORD = "Pandit";  // Replace with your desired password

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String enteredUsername = scanner.nextLine();

        System.out.print("Enter password: ");
        String enteredPassword = scanner.nextLine();

        if (authenticate(enteredUsername, enteredPassword)) {
            System.out.println("Authentication successful!");

            MovieShowService movieShowService = new MovieShowService();
            displayAvailableDates(movieShowService, scanner);

            // Close scanner when done
            scanner.close();
        } else {
            System.out.println("Authentication failed. Exiting...");
            scanner.close();
        }
    }

    private static boolean authenticate(String enteredUsername, String enteredPassword) {
        return USERNAME.equals(enteredUsername) && PASSWORD.equals(enteredPassword);
    }

    private static void displayAvailableDates(MovieShowService movieShowService, Scanner scanner) {
        System.out.println("Available Show Dates:");
        movieShowService.showAvailableDates();

        System.out.print("Enter the desired show date (e.g., 8-Dec): ");
        String selectedDate = scanner.nextLine();

        // Display available shows for the selected date
        
        // Ask user if they want to book a ticket
       
        
        movieShowService.bookTicket(selectedDate, scanner);
    }
}

    

