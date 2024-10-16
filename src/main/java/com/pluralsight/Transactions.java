package com.pluralsight;
import java.io.*;
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
    // Method to display ALL entries
    public static void displayAllEntries(){
        try(BufferedReader bufReader = new BufferedReader(new FileReader("transactions.csv"))){
            String line;
            while ((line = bufReader.readLine()) != null){
                System.out.println(line);
            }
            //close reader
            bufReader.close();
        }
        catch (IOException e){
            System.out.println("Error reading file");
        }
    }
    // if statement to show only Deposits
    public static void displayOnlyDeposits(){
        try(BufferedReader reader = new BufferedReader(new FileReader("transactions.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                //Splitting inputs in to their categories
               String[] parts = line.split("\\|");
               // there are 5 categories
                if(parts.length == 5){
                    //parse amount section
                    double amount = Double.parseDouble(parts[5]);
                    // comparing if value is + or -, indicating deposit or payment
                    if(amount < 0){
                        System.out.println(line);
                    }
                }
            }
        }
            catch(IOException e){
                System.out.println("Error reading file");

            }

    }
    // if statement to show only Payments
    public static void displayPaymentsOnly(){
        try(BufferedReader reader = new BufferedReader(new FileReader("transactions.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
               String[] parts = line.split("\\|");
               if(parts.length == 5){
                   double amount = Double.parseDouble(parts[5]);

                   if(amount < 0){
                       System.out.println(line);
                   }
                }
            }
        }
        catch(IOException e) {
            System.out.println("Error reading file");
        }

    }
}


