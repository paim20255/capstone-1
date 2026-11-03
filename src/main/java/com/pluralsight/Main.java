package com.pluralsight;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    private static final String File_Name = "transaction.csv";
    private static final Scanner myscanner = new Scanner(System.in);

    public static void main(String[] args) {
        homeScreen();
        System.out.println("Goodbye");

    }
    // Working on the HOME Screen
    private static void homeScreen() {
        boolean running = true;

        while (running) {
            System.out.println("\n====Home====");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment (Debit)");
            System.out.println("L) Ledger");
            System.out.println("X) Exit");
            System.out.print("Choose an option: ");

            String choice = myscanner.nextLine().trim().toUpperCase();

            switch (choice) {
                case "D":
                    addTransaction(true);
                    break;
                case "P":
                    addTransaction(false);
                    break;
                case "L":
                    ledgerScreen();
                    break;
                case "X":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option, please try again.");

            }


        }
    }


    private static void addTransaction(boolean isDeposit) {
        if (isDeposit) {
            System.out.println("\n--- Add Deposit ---");
        } else {
            System.out.println("\n--- Make Payment ---");
        }
        System.out.print("Description: ");
        String description = myscanner.nextLine();

        System.out.print("Vendor: ");
        String vendor = myscanner.nextLine();

        System.out.print("Amount: ");
        double amount;
    }

    private static void ledgerScreen() {
    }
}
