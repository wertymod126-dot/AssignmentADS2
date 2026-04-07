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
    }
}