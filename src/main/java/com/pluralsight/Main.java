package com.pluralsight;

import java.util.Scanner;

public class Main {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        mainMenu(scanner);

    }
        //Display Menu #1 (D, P, L, X)
        public static void mainMenu (Scanner scanner){
            while (true) {
                System.out.println("\nMenu\n");
                System.out.println("D): Add Deposit ");
                System.out.println("P): Make Payment (Debit)");
                System.out.println("L): Ledger");
                System.out.println("X): Exit");
                System.out.println("\n Enter your command:\n");
                //Make command uppercase, will not be case-sensitive
                String command = scanner.nextLine().toUpperCase();

                switch (command) {
                    case "D":
                        addDeposit();
                        break;
                    case "P":
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
        public static void addDeposit () {
            System.out.println("NEED CSV FILE");
        }
        public static void makePayment () {
            System.out.println("Need CSV FILE STILL");
        }
//adding scanner because this will open a new menu
        public static void ledgerMenu (Scanner scanner){
            while (true) {
                System.out.println("A) All");
                System.out.println("D) Deposits");
                System.out.println("P) Payments");
                System.out.println("R) Reports");
                System.out.println("H) Home");
                String command = scanner.nextLine().toUpperCase();

                //new swtich method for Ledger menu
                switch (command) {
                    case "A":
                        break;
                    case "D":
                        break;
                    case "P":
                        break;
                    case "R":
                        reportsMenu(scanner);
                    case "H":
                        mainMenu(scanner);

                }
            }
        }
        public static void reportsMenu (Scanner scanner){
            while (true) {
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
                        return;
                    case "2":
                        return;
                    case "3":
                        return;
                    case "4":
                        return;
                    case "5":
                        return;
                    case "6":
                        return;
                    case "0":
                        return;
                    case "H":
                        mainMenu(scanner);
                }
            }
        }
        public static void customSearch(Scanner scanner){
            System.out.println("\nPlease Enter The Following:\n");
            System.out.println("• Start Date: ");
            String startDate = scanner.nextLine();
            System.out.println("• End Date: ");
            String endDate = scanner.nextLine();
            System.out.println("• Description: ");
            String description = scanner.nextLine();
            System.out.println("• Vendor: ");
            String vendorName = scanner.nextLine();
            System.out.println("• Amount: ");
            double searchAmount = scanner.nextDouble();
        }
    }
