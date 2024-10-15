package com.pluralsight;
import java.time.LocalDateTime;

public class Transactions {
    //Attributes
    private LocalDateTime dateTime;
    private String description;
    private String vendor;
    private double amount;

    //Constructor
    public Transactions(LocalDateTime _dateTime, String _description, String _vendor, double _amount){
        this.dateTime = _dateTime;
        this.description = _description;
        this.vendor = _vendor;
        this.amount = _amount;
    }
    //empty constructor
    public Transactions(){
    }
    //Get + Set Methods
    public LocalDateTime getDateTime(){
        return dateTime;
    }
    public void setDateTime(LocalDateTime dateTime){
        this.dateTime = dateTime;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getVendor(){
        return vendor;
    }
    public void setVendor(String vendor){
        this.vendor = vendor;
    }
    public double getAmount(){
        return amount;
    }
    public void setAmount(double amount){
        this.amount = amount;
    }
}


