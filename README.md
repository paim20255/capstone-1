# Accounting Ledger

## Description
A Java console application that manages financial transactions. Users can add deposits and payments, view a ledger of all transactions, generate month-to-date or year-to-date reports, and search for specific vendors.

## Features
- Add Transaction (Deposit/Payment)
- View Ledger (All Transactions)
- Reports:
    - Month-to-Date
    - Previous Month
    - Year-to-Date
    - Previous Year
- Search by Vendor

## Requirements
- Java 17
- IntelliJ 

## How to Run
1. Clone the repository.
2. Open the project in IntelliJ IDEA.
3. Run the `AccountingLedger` class.
4. Follow the menu prompts in the console.

## My Home Screen!
```java
            System.out.println("\n====Home====");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment (Debit)");
            System.out.println("L) Ledger");
            System.out.println("X) Exit");
            System.out.print("Choose an option: ");
