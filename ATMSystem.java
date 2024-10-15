import java.util.ArrayList;
import java.util.Scanner;

public class ATMSystem {




        private static Scanner scanner = new Scanner(System.in);
        private static double balance = 1000.0;  // Default balance
        private static ArrayList<String> transactionHistory = new ArrayList<>();

        public static void main(String[] args) {
            boolean loggedIn = login();
            if (loggedIn) {
                int choice;
                do {
                    System.out.println("\nATM Menu:");
                    System.out.println("1. Transaction History");
                    System.out.println("2. Withdraw");
                    System.out.println("3. Deposit");
                    System.out.println("4. Transfer");
                    System.out.println("5. Quit");
                    System.out.print("Enter your choice: ");
                    choice = scanner.nextInt();

                    switch (choice) {
                        case 1:
                            showTransactionHistory();
                            break;
                        case 2:
                            withdraw();
                            break;
                        case 3:
                            deposit();
                            break;
                        case 4:
                            transfer();
                            break;
                        case 5:
                            System.out.println("Thank you for using the ATM. Goodbye!");
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                } while (choice != 5);
            }
        }

        private static boolean login() {
            String correctUserID = "user123";
            String correctPin = "1234";

            System.out.println("Welcome to the ATM!");
            System.out.print("Enter User ID: ");
            String userID = scanner.next();
            System.out.print("Enter PIN: ");
            String pin = scanner.next();

            if (userID.equals(correctUserID) && pin.equals(correctPin)) {
                System.out.println("Login successful.");
                return true;
            } else {
                System.out.println("Invalid User ID or PIN.");
                return false;
            }
        }

        private static void showTransactionHistory() {
            if (transactionHistory.isEmpty()) {
                System.out.println("No transactions yet.");
            } else {
                System.out.println("Transaction History:");
                for (String transaction : transactionHistory) {
                    System.out.println(transaction);
                }
            }
        }

        private static void withdraw() {
            System.out.print("Enter amount to withdraw: ");
            double amount = scanner.nextDouble();

            if (amount > balance) {
                System.out.println("Insufficient balance.");
            } else {
                balance -= amount;
                System.out.println("Withdrawal successful. New balance: $" + balance);
                transactionHistory.add("Withdrawn: $" + amount);
            }
        }

        private static void deposit() {
            System.out.print("Enter amount to deposit: ");
            double amount = scanner.nextDouble();

            balance += amount;
            System.out.println("Deposit successful. New balance: $" + balance);
            transactionHistory.add("Deposited: $" + amount);
        }

        private static void transfer() {
            System.out.print("Enter amount to transfer: ");
            double amount = scanner.nextDouble();
            System.out.print("Enter recipient's account number: ");
            String recipient = scanner.next();

            if (amount > balance) {
                System.out.println("Insufficient balance.");
            } else {
                balance -= amount;
                System.out.println("Transferred $" + amount + " to account: " + recipient);
                System.out.println("New balance: $" + balance);
                transactionHistory.add("Transferred: $" + amount + " to account: " + recipient);
            }
        }
    }


