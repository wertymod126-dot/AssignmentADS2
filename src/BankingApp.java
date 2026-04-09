import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BankingApp {

    // --- System Data Structures ---
    // 1. LinkedList for Active Accounts
    static BankLinkedList activeAccounts = new BankLinkedList();

    // 2. Stack for Transaction History (LIFO)
    static Stack<String> transactionHistory = new Stack<>();

    // 3. Queues for Admin Processing (FIFO)
    static Queue<String> accountRequests = new LinkedList<>();
    static Queue<String> billQueue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Pre-fill some data so the system isn't empty
        activeAccounts.addAccount("101", "Ali", 150000);
        billQueue.add("Electricity Bill");
        billQueue.add("Internet Bill");

        while (true) {
            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1 - Enter Bank");
            System.out.println("2 - Enter ATM");
            System.out.println("3 - Admin Area");
            System.out.println("4 - Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Clear the scanner buffer

            if (choice == 1) {
                bankMenu(sc);
            } else if (choice == 2) {
                atmMenu(sc);
            } else if (choice == 3) {
                adminMenu(sc);
            } else if (choice == 4) {
                System.out.println("Exiting System. Goodbye!");
                break; // Ends the program
            } else {
                System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }

    // --- 1. BANK MENU ---
    public static void bankMenu(Scanner sc) {
        System.out.println("\n--- Bank Menu ---");
        System.out.println("1. Submit Account Opening Request");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.print("Choose: ");
        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 1) {
            System.out.print("Enter your name to apply: ");
            String name = sc.nextLine();
            accountRequests.add(name); // Adds to Queue
            System.out.println("Request submitted. Please wait for Admin approval.");
        }
        else if (choice == 2) {
            System.out.print("Enter username: ");
            String name = sc.nextLine();
            System.out.print("Deposit amount: ");
            double amount = sc.nextDouble();

            // In a real scenario, you'd call activeAccounts.deposit() here.
            // For now, we simulate the logic and record history.
            transactionHistory.push("Deposited " + amount + " to " + name);
            System.out.println("Deposit successful.");
        }
        else if (choice == 3) {
            System.out.print("Enter username: ");
            String name = sc.nextLine();
            System.out.print("Withdraw amount: ");
            double amount = sc.nextDouble();

            transactionHistory.push("Withdrew " + amount + " from " + name);
            System.out.println("Withdrawal successful.");
        }
    }

    // --- 2. ATM MENU ---
    public static void atmMenu(Scanner sc) {
        System.out.println("\n--- ATM Menu ---");
        System.out.println("1. Balance Enquiry");
        System.out.println("2. Withdraw");
        System.out.print("Choose: ");
        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 1) {
            System.out.print("Enter username: ");
            String name = sc.nextLine();
            activeAccounts.searchAccount(name); // Searches the LinkedList
        } else if (choice == 2) {
            System.out.print("Enter username: ");
            String name = sc.nextLine();
            System.out.print("Amount to withdraw: ");
            double amount = sc.nextDouble();

            transactionHistory.push("ATM Withdrawal of " + amount + " by " + name);
            System.out.println("Please take your cash.");
        }
    }

    // --- 3. ADMIN MENU ---
    public static void adminMenu(Scanner sc) {
        System.out.println("\n--- Admin Area ---");
        System.out.println("1. View/Process Account Queue");
        System.out.println("2. View/Process Bill Payment Queue");
        System.out.println("3. View Recent Transactions (Stack)");
        System.out.print("Choose: ");
        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 1) {
            System.out.println("Current Requests: " + accountRequests);
            if (!accountRequests.isEmpty()) {
                String newClient = accountRequests.poll(); // Removes from Queue
                // Generates a random ID for the new account
                activeAccounts.addAccount("999", newClient, 0.0);
                System.out.println("Processed and approved: " + newClient);
            } else {
                System.out.println("No pending requests.");
            }
        }
        else if (choice == 2) {
            System.out.println("Pending Bills: " + billQueue);
            if (!billQueue.isEmpty()) {
                String paidBill = billQueue.poll();
                System.out.println("Processed payment for: " + paidBill);
                transactionHistory.push("Paid bill: " + paidBill);
            }
        }
        else if (choice == 3) {
            System.out.println("Last Transaction: " +
                    (transactionHistory.isEmpty() ? "None" : transactionHistory.peek()));
        }
    }
}