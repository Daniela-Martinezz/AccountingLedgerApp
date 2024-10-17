package com.pluralsight;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FinancialTransactionsCLI {
    //Attributes
    private LocalDateTime dateTime;
    private String description;
    private String vendor;
    private double amount;
    public static boolean headerWritten = false;

    //Constructor
    public FinancialTransactionsCLI(LocalDateTime _dateTime, String _description, String _vendor, double _amount) {
        this.dateTime = _dateTime;
        this.description = _description;
        this.vendor = _vendor;
        this.amount = _amount;

    }

    //empty constructor
    public FinancialTransactionsCLI() {
    }

    //Get + Set Methods
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

// Format for file
    @Override
    public String toString() {
        DateTimeFormatter dateFormatted = DateTimeFormatter.ofPattern("yyyy-MM-dd|HH:mm:ss");
        String date = dateTime.toLocalDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String time = dateTime.toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        return date + "|" + time + "|" + description + "|" + vendor + "|" + amount;
    }
}


