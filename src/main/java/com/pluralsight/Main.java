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

        System.out.print("Description: ");
        String description = myscanner.nextLine();

        System.out.print("Vendor: ");
        String vendor = myscanner.nextLine();

        System.out.print("Amount: ");
        String amountTaken = myscanner.nextLine();
        double amount = Double.parseDouble(amountTaken);


        amount = -1 * amount;

      /*  try {
            FileReader fileReader = new FileReader("transaction.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            bufferedReader.read();

            FileWriter fileWriter = new FileWriter(File_Name);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write("");

            bufferedReader.close();
            bufferedWriter.close();


        } catch (IOException e) {
            System.out.println("Invalid, try again.");
        } */


    }


    private static void ledgerScreen() {
    }

    }



