package com.pluralsight;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
        String File_Name = "src/main/resources/transaction.csv";

        System.out.println("\n--- Add Deposit ---");

        System.out.print("Description: ");
        String description = myscanner.nextLine();

        System.out.print("Vendor: ");
        String vendor = myscanner.nextLine();

        System.out.print("Amount: ");
        String amountText = myscanner.nextLine();
        double amount = Double.parseDouble(amountText);

        LocalDateTime today = LocalDateTime.now();
        LocalDate date = LocalDate.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formatterDate = today.format(fmt);

        String result = (date + "|" + formatterDate + "|" + description + "|" + vendor + "|" + amount);

        try {
            FileWriter writer = new FileWriter(File_Name, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            writer.write("transaction\n");
            bufferedWriter.write(result);

            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Error, please try again.");
        }

    }

    private static void addPayment() {
        String File_Name = "src/main/resources/transaction.csv";
        Scanner myscanner = new Scanner(System.in);

        System.out.println("\n--- Make Payment ---");

        System.out.print("Description: ");
        String description = myscanner.nextLine();

        System.out.print("Vendor: ");
        String vendor = myscanner.nextLine();

        System.out.print("Amount: ");
        String amountTaken = myscanner.nextLine();
        double amount = Double.parseDouble(amountTaken);

        amount = -1 * amount;

        LocalDateTime today = LocalDateTime.now();
        LocalDate date = LocalDate.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formatterDate = today.format(fmt);

        String paymentResult =(date + "|" + formatterDate + "|" + description + "|" + vendor + "|" + amount);

        try {
            FileWriter writer = new FileWriter(File_Name, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            writer.write("\n");
            bufferedWriter.write(paymentResult);

            bufferedWriter.close();

        } catch (IOException e) {
            System.out.println("Error");
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
        Scanner myscanner = new Scanner(System.in);

        boolean report = true;

        while (report) {

            System.out.println("\n===== REPORT SCREEN =====");
            System.out.println("1) Month To Date");
            System.out.println("2) Previous Month");
            System.out.println("3) Year to Date");
            System.out.println("4) Previous Year");
            System.out.println("5) Search By Vendor");
            System.out.println("0) Back");
            System.out.println("H) Home");
            System.out.print("Choose an option: ");

            String choice = myscanner.nextLine().toUpperCase();

            switch (choice) {
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "0":
                    return;
                case "H":
                    return;
                default:
                    System.out.println("Not an option, please try again");
            }

        }
    }


    private static void allEntries() {
        // todo: open transaction file for reading
        // todo: read each line in the file and print it

    }

    private static void displayDeposits() {
    }

    private static void displayPayments() {

    }
}









