# Accounting Ledger Application

This simple command-line application built in Java allows users to manage their financial transactions. The application supports functionalities such as adding deposits, making payments, and viewing a ledger of transactions. It also offers reporting capabilities to generate summaries for different periods.

## Features
- **Add Deposit**: Add a new deposit with a specified amount, description, and vendor.
- **Make Payment**: Make a payment (debit) by specifying the amount, description, and vendor.
- **View Ledger**: Display all transactions, or filter by deposits and payments.
- **Reports**: Generate reports for month-to-date, previous month, year-to-date, and previous year transactions. You can also search transactions by vendor.
- **CSV Storage**: All transactions are stored in a CSV file (`transactions.csv`).

## How It Works
1. **Main Menu**:
   - The user has options to add a deposit, make a payment, view the ledger, or exit the application.
   
2. **Ledger Menu**:
   - Allows viewing all transactions, deposits, payments, or access to the reports menu. There is an option to go back to the main menu.

3. **Reports Menu**:
   - Provides various reporting options: month-to-date, previous month, year-to-date, previous year, and searching transactions by vendor.

## File Structure
- **`TransactionApp.java`**: The main entry point of the application contains the menus and core functionalities like adding deposits, making payments, and navigating between menus.
- **`Ledger.java`**: Handles the CSV file for transactions, including adding transactions and filtering them by type (deposits or payments).
- **`Reports.java`**: Generates reports from the transaction data for different periods and allows searching by vendor.
- **`FinancialTransactionsCLI.java`**: Represents a financial transaction and handles its formatting and data management.



## Demo: Adding Transactions
![EnteringTransactions](https://github.com/user-attachments/assets/31ab66dc-da99-42b9-8373-d029855e3598)

**Description**: The user adds two types of transactions, including descriptions, vendor name, and amount.

## Demo: Viewing Transactions
![ViewingTransactions](https://github.com/user-attachments/assets/460231aa-bf06-4e61-b758-2c60128ef0c3)

**Description**: The user is viewing the transactions by choosing the "Payments" and "Deposits" options in the 'Ledger Menu'



