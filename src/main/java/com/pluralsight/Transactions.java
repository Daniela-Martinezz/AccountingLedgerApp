package com.pluralsight;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transactions {
    //Attributes
    private LocalDateTime dateTime;
    private String description;
    private String vendor;
    private double amount;
    public static boolean headerWritten = false;

    //Constructor
    public Transactions(LocalDateTime _dateTime, String _description, String _vendor, double _amount) {
        this.dateTime = _dateTime;
        this.description = _description;
        this.vendor = _vendor;
        this.amount = _amount;
    }

    //empty constructor
    public Transactions() {
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
        return dateTime.format(dateFormatted) + "|" + description + "|" + vendor + "|" + amount;
    }

    //transaction output for payments/deposits
    public static void addTransaction(String type, double amount, String description, String vendor) {
        LocalDateTime dateTime = LocalDateTime.now();
        Transactions transaction = new Transactions(dateTime, description, vendor, amount);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("transactions.csv", true))) {

            //Making sure header is written once
            if (!headerWritten){
                writer.write("date|time|description|vendor|amount");
                writer.newLine();
                headerWritten = true;
            }

            writer.write(transaction.toString());
            writer.newLine();
            System.out.println(type + " for $" + amount + " complete.");
        } catch (IOException e) {
            System.out.println("An unexpected error occurred");
        }
    }
}


