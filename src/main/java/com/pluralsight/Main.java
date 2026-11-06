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
        System.out.println("Goodbye, thank you for using our application.");
    }

    // Working on the HOME Screen
    private static void homeScreen() {
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

            writer.write("\n");
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
                    break;
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
            System.out.print("Choose an option: ");

            String choice = myscanner.nextLine().toUpperCase();

            switch (choice) {
                case "1":
                    displayMonthToDate();
                    break;
                case "2":
                    displayPreviousMonth();
                    break;
                case "3":
                    displayYearToDate();
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Not an option, please try again");
            }
        }
    }

    private static void displayYearToDate() {
        String fileNames = "src/main/resources/transation.csv";

        LocalDate today = LocalDate.now();

        int year = today.getYear();

        try {
            FileReader fileReader = new FileReader(fileNames);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            bufferedReader.readLine();


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void displayPreviousMonth() {
        String fileName = "src/main/resources/transaction.csv";

        LocalDate today = LocalDate.now();
        LocalDate lastMonth = today.minusMonths(1);

        int targetMonth = lastMonth.getMonthValue();
        int targetYear = lastMonth.getYear();

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            bufferedReader.readLine();

            String line = bufferedReader.readLine();

            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split("\\|");

                LocalDate transactionDate = LocalDate.parse(parts[0]);

                if (transactionDate.getYear() == targetYear && transactionDate.getMonthValue() == targetMonth) {
                    System.out.println(line);
                }
            }


        } catch (FileNotFoundException e) {
            System.out.println("Option not found.");
        } catch (IOException e) {
            System.out.println("Error!");
        }


    }

    private static void displayMonthToDate() {
        String fileName = "src/main/resources/transaction.csv";

        LocalDate today = LocalDate.now();
        int currentMonth = today.getMonthValue();
        int currentYear = today.getYear();

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            bufferedReader.readLine();

            String line = bufferedReader.readLine();

            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split("\\|");

                LocalDate transactionDate = LocalDate.parse(parts[0]);

                if (transactionDate.getYear() == currentYear && transactionDate.getMonthValue() == currentMonth) {
                    System.out.println(line);
                }
            }


        } catch (FileNotFoundException e) {
            System.out.println("Error reading the file.");
        } catch (IOException e) {
            System.out.println();
        }


        // done: first get today's date as LocalDate object
        // done: get current year from today's date, e.g. 2026
        // // done: get the current month from today's , e.g. 1, or 11
        //  loop through your transaction lines like in displayDeposit
        // done: get the date of the transaction as LocalDate
        // done: for each transaction, if the transaction year is current year and
        // transaction month is the current month, print it, baby!
    }


    private static void allEntries() {
        String fileName = "src/main/resources/transaction.csv";

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();

            // Read until there is nothing else to read.
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);

            }
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error!");
        } catch (IOException e) {
            System.out.println();
        }

        // done: open transaction file for reading
        // done: read each line in the file and print it

    }

    private static void displayDeposits() {
        String fileName = "src/main/resources/transaction.csv";

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();

            while ((line = bufferedReader.readLine()) != null) {
                String[] lineParts = line.split("\\|");

                double depositPayment = Double.parseDouble(lineParts[4]);

                if (depositPayment > 0) {
                    System.out.println(line);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error, try again.");
        } catch (IOException e) {
            System.out.println("Please select a different option!");
        }
    }

    private static void displayPayments() {
// done: same as displayDeposit but with different sign
        String fileName = "src/main/resources/transaction.csv";

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();

            while ((line = bufferedReader.readLine()) != null) {
               String[] parts = line.split("\\|");

               double makePayment = Double.parseDouble(parts[4]);

               if (makePayment < 0){
                   System.out.println(line);
               }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Invalid Try again.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}









