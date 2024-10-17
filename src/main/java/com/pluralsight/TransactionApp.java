package com.pluralsight;

import java.util.Scanner;

public class TransactionApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        mainMenu(scanner);

    }
        //Display Menu #1 (D, P, L, X)..
        //While(true) keep running til exit(return, break)
        public static void mainMenu (Scanner scanner){
            while (true) {
                System.out.println("\nMain Menu\n");
                System.out.println("D): Add Deposit ");
                System.out.println("P): Make Payment (Debit)");
                System.out.println("L): Ledger");
                System.out.println("X): Exit");
                System.out.println("\n Enter your command:\n");
                //Make command uppercase, will not be case-sensitive
                String command = scanner.nextLine().toUpperCase();

                switch (command) {
                    case "D":
                        addDeposit(scanner);
                        break;
                    case "P":
                        makePayment(scanner);
                        break;
                    case "L":
                        ledgerMenu(scanner);
                        break;
                    case "X":
                        System.out.println("Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid command");
                }
            }
        }
        //CSV file for deposit
        public static void addDeposit (Scanner scanner){
            // Asking user to input fields
            System.out.println("Enter deposit amount: ");
            double depositAmount = scanner.nextDouble();
            if (depositAmount < 0){
                System.out.println("Invalid input. Deposit amount must be positive");
                return;
            }
            scanner.nextLine();
            System.out.println("Enter description: ");
            String description = scanner.nextLine();
            System.out.println("Enter vendor: ");
            String vendor = scanner.nextLine();

            Ledger.addTransaction(depositAmount, description, vendor);
        }
        public static void makePayment (Scanner scanner){
            System.out.println("Enter payment amount: ");
            double paymentAmount = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Enter description: ");
            String description = scanner.nextLine();
            System.out.println("Enter vendor: ");
            String vendor = scanner.nextLine();

           Ledger.addTransaction(-paymentAmount, description,vendor);
        }
        //Ledger menu
        public static void ledgerMenu (Scanner scanner){
            while (true) {
                System.out.println("\nLedger Menu\n");
                System.out.println("A) All");
                System.out.println("D) Deposits");
                System.out.println("P) Payments");
                System.out.println("R) Reports");
                System.out.println("H) Home");
                String command = scanner.nextLine().toUpperCase();

                //new swtich method for Ledger menu
                switch (command) {
                    case "A":
                        Ledger.displayAllEntries();
                        break;
                    case "D":
                        Ledger.displayOnlyDeposits();
                        break;
                    case "P":
                        Ledger.displayPaymentsOnly();
                        break;
                    case "R":
                        reportsMenu(scanner);
                        break;
                    case "H":
                       return;
                    default:
                        System.out.println("Invalid Input");
                }
            }
        }
        //Reports menu
        public static void reportsMenu (Scanner scanner){
        //while(true) infinite loop for menu
            while (true) {
                System.out.println("\nSelect Option Below:\n ");
                System.out.println("1) Month to Date");
                System.out.println("2) Previous Month");
                System.out.println("3) Year To Date");
                System.out.println("4) Previous Year");
                System.out.println("5) Search by Vendor");
                System.out.println("6) Custom Search");
                System.out.println("0) Back");
                System.out.println("H) Home");
                String command = scanner.nextLine().toUpperCase();

                //switch for reports menu
                switch (command) {
                    case "1":
                        Reports.monthToDateReport();
                        break;
                    case "2":
                        Reports.previousMonth();
                        break;
                    case "3":
                        Reports.yearToDate();
                        break;
                    case "4":
                        Reports.previousYear();
                        break;
                    case "5":
                        Reports.searchByVendor();
                        break;
                    case "0":
                        return;
                    case "H":
                        mainMenu(scanner);
                        break;
                }
            }
        }
}
