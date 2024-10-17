package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Reports {

        //Read from CSV
        public static List<FinancialTransactionsCLI> readFromCsv(){
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
                                // Parse file into parts
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

}

