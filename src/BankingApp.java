import java.util.Scanner;

public class BankingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankLinkedList masterList = new BankLinkedList();
        AdminSimulation admin = new AdminSimulation(); //
        TransactionManager history = new TransactionManager(); //
        BillPaymentQueue bills = new BillPaymentQueue(); //

        // --- Task 6: Array of Predefined Accounts ---
        BankAccount[] initialData = new BankAccount[3]; //
        initialData[0] = new BankAccount("1001", "Alice", 500.0);
        initialData[1] = new BankAccount("1002", "Bob", 1200.0);
        initialData[2] = new BankAccount("1003", "Charlie", 750.0);

        for (BankAccount acc : initialData) {
            masterList.addAccount(acc.accountNumber, acc.username, acc.balance); //
        }

        while (true) {
            System.out.println("\n1. Bank | 2. ATM | 3. Admin | 4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) { // BANK MENU
                System.out.println("1. Request Account | 2. Deposit | 3. Withdraw");
                int sub = scanner.nextInt(); scanner.nextLine();

                if (sub == 1) {
                    System.out.print("Username: "); String u = scanner.nextLine();
                    System.out.print("Initial $: "); double d = scanner.nextDouble();
                    admin.submitAccountRequest("ID-" + u, d, u); //
                } else {
                    System.out.print("Username: "); String u = scanner.nextLine();
                    BankAccount acc = masterList.findAccount(u);
                    if (acc != null) {
                        System.out.print("Amount: "); double amt = scanner.nextDouble();
                        if (sub == 2) {
                            acc.balance += amt; //
                            history.addTransaction("Deposited " + amt + " to " + u); //
                        } else if (acc.balance >= amt) {
                            acc.balance -= amt; //
                            history.addTransaction("Withdrew " + amt + " from " + u); //
                        }
                    } else { System.out.println("User not found."); }
                }

            } else if (choice == 2) { // ATM MENU
                System.out.print("Username: "); String u = scanner.nextLine();
                BankAccount acc = masterList.findAccount(u);
                if (acc != null) {
                    System.out.println("1. Balance | 2. Withdraw");
                    int sub = scanner.nextInt();
                    if (sub == 1) System.out.println("Balance: " + acc.balance); //
                    else {
                        System.out.print("Amt: "); double amt = scanner.nextDouble();
                        if (acc.balance >= amt) acc.balance -= amt; //
                    }
                }

            } else if (choice == 3) { // ADMIN MENU
                System.out.println("1. Process Account Queue | 2. View Bills");
                int sub = scanner.nextInt();
                if (sub == 1) admin.processRequest("process"); //
                else bills.displayBills(); //

            } else if (choice == 4) break;
        }
    }
}