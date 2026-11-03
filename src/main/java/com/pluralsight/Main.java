package com.pluralsight;

import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        homeScreen();
        System.out.println("Goodbye");
    }

    // Working on the HOME Screen
    private static void homeScreen() {
        // String File_Name = "transaction.csv";
        Scanner myscanner = new Scanner(System.in);

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
                    addDeposit();
                    break;
                case "P":
                    addPayment();
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
    private static void addDeposit() {
        Scanner myscanner = new Scanner(System.in);

        System.out.println("\n--- Add Deposit ---");

        System.out.print("Description: ");
        String description = myscanner.nextLine();

        System.out.print("Vendor: ");
        String vendor = myscanner.nextLine();

        System.out.print("Amount: ");
        String amountText = myscanner.nextLine();
        double amount = Double.parseDouble(amountText);

        amount = 1 * amount;
    }

    private static void addPayment() {
        String File_Name = "transaction.csv";
        Scanner myscanner = new Scanner(System.in);

        System.out.println("\n--- Make Payment ---");

        System.out.print("Description: ");
        String description = myscanner.nextLine();

        System.out.print("Vendor: ");
        String vendor = myscanner.nextLine();

        System.out.print("Amount: ");
        String amountTaken = myscanner.nextLine();
        double amount = Double.parseDouble(amountTaken);

        if (amount <= 0) {
            amount = -1 * amount;
        }

    }
    private static void ledgerScreen() {
        Scanner myscanner = new Scanner(System.in);

        boolean ledger = true;

        while (ledger) {
            System.out.println("\n===== LEDGER =====");
            System.out.println("A) All");
            System.out.println("D) Deposits");
            System.out.println("P) Payments");
            System.out.println("R) Reports");
            System.out.println("H) Home");
            System.out.print("Choose an option: ");

            String choice = myscanner.nextLine().toUpperCase();

            switch (choice) {
                case "A":
                    allEntries();
                    break;
                case "D":
                    displayDeposits();
                    break;
                case "P":
                    displayPayments();
                case "R":
                    reportScreen();
                    break;
                case "H":
                    return;
                default:
                    System.out.println("Not an Option");
            }
        }


    }

    private static void reportScreen() {
    }

    private static void displayPayments() {
    }

    private static void displayDeposits() {
    }

    private static void allEntries() {
    }

}



