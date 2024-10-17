package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reports {

        //Read from CSV file
        public static List<FinancialTransactionsCLI> readFromCsv(){
                //Specify we are storing FinancialTransactionsCLI objects
                List<FinancialTransactionsCLI> transactionList = new ArrayList<>();
                String transactionsFile = "transactions.csv";

                try (BufferedReader reader = new BufferedReader(new FileReader(transactionsFile))) {
                        String line;
                        boolean isFirstLine = true;

                        while((line = reader.readLine()) != null) {
                                if (isFirstLine){
                                        isFirstLine = false; //skipping header
                                        continue;
                                }
                                // Parse file into parts, date|time|desc.|vendor|$
                                String[] parts = line.split("\\|");
                                if (parts.length == 5){
                                        LocalDateTime dateTime = LocalDateTime.parse(parts[0] + "T" + parts[1]);
                                        String description = parts[2];
                                        String vendor = parts[3];
                                        double amount = Double.parseDouble(parts[4]);

                                        FinancialTransactionsCLI transaction = new FinancialTransactionsCLI(dateTime, description, vendor, amount);
                                        transactionList.add(transaction);
                                }
                        }
                } catch (IOException e){
                        System.out.println("Error reading file: " + e.getMessage());
                }
                return transactionList;
        }
      //month to date filter
      public static void monthToDateReport() {
                List<FinancialTransactionsCLI> transactions = readFromCsv();
                LocalDate now = LocalDate.now();

              System.out.println("\nMonth to Date Report:\n");
              for (FinancialTransactionsCLI transaction : transactions){
                      if (transaction.getDateTime().toLocalDate().getMonth() == now.getMonth() &&
                      transaction.getDateTime().toLocalDate().getYear() == now.getYear()){
                              System.out.println(transaction);
                      }
              }
      }
        public static void previousMonth() {
                List<FinancialTransactionsCLI> transactions = readFromCsv();
                LocalDate now = LocalDate.now();
                LocalDate previousMonthDate = LocalDate.now().minusMonths(1);
                int previousMonth = previousMonthDate.getMonthValue();

                System.out.println("\nPrevious Month:\n");
                for (FinancialTransactionsCLI transaction : transactions) {
                        LocalDate transactionsDate = transaction.getDateTime().toLocalDate();

                        if (transaction.getDateTime().toLocalDate().getYear() == now.getYear() &&
                                transactionsDate.getMonthValue() == previousMonth){
                                System.out.println(transaction);
                        }
                }
        }
                public static void yearToDate() {
                        List<FinancialTransactionsCLI> transactions = readFromCsv();
                        LocalDate now = LocalDate.now();

                        System.out.println("\nYear To Date:\n");
                        for (FinancialTransactionsCLI transaction : transactions) {
                              if (transaction.getDateTime().toLocalDate().getYear() == now.getYear()) {
                                        System.out.println(transaction);
                                }

                        }
                }
        public static void previousYear() {
                List<FinancialTransactionsCLI> transactions = readFromCsv();
                LocalDate now = LocalDate.now();
                int previousYear = now.getYear() -1;

                System.out.println("\nPrevious Year Transactions:\n");
                for (FinancialTransactionsCLI transaction : transactions) {
                        if (transaction.getDateTime().toLocalDate().getYear() == previousYear) {
                                System.out.println(transaction);
                        }

                }
        }
        public static void searchByVendor(){
                List<FinancialTransactionsCLI> transactions = readFromCsv();
                Scanner scanner = new Scanner(System.in);

                //Ask user for vendor name
                System.out.println("Enter the vendor name to search: ");
                String vendorToSearch = scanner.nextLine().trim();

                //in case no transaction is found
                boolean transactionsFound = false;

                //Loop to find matches
                for (FinancialTransactionsCLI transaction : transactions) {
                        //vendor = users input
                        if (transaction.getVendor().equalsIgnoreCase(vendorToSearch)){
                                System.out.println(transaction);
                                transactionsFound = true;
                        }
                }
                //no transactions found
                if (!transactionsFound) {
                        System.out.println("No transactions found for vendor: " + vendorToSearch);
                }
        }
}
