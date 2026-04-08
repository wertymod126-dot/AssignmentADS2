import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankLinkedList list = new BankLinkedList();
        Scanner sc = new Scanner(System.in);

        // Pre-filling with example data
        list.addAccount("John doe", 150000, 101);
        list.addAccount("Adilbek", 220000, 102);

        list.displayAccounts();

        System.out.print("\nEnter username to search: ");
        String searchName = sc.nextLine();
        list.searchAccount(searchName);

        sc.close();
        TransactionManager tm = new TransactionManager();

        // Adding transactions
        tm.addTransaction("Deposit 50000 to Ali");
        tm.addTransaction("Withdraw 20000 from Ali");

        // Peek at the top of the stack
        tm.showLastTransaction();

        // Pop the last item (Undo)
        tm.undoTransaction();

        // Final check
        tm.showLastTransaction();
    }
}