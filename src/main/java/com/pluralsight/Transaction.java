package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Transaction {
    private LocalDate date;
    private LocalDateTime time;
    private String description;
    private String vendor;
    private double amount;


    public Transaction(LocalDate date, LocalDateTime time, String description, String vendor, double amount){
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

}
