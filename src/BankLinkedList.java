public class BankLinkedList {
    private Node head;

    public void addAccount(String id, String username, double balance) {
        BankAccount newaccount = new BankAccount(id, username, balance);
        Node newnode = new Node(newaccount);

        if (head == null) {
            head = newnode;
        }
        else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newnode;
        }
        System.out.println("New account has been added to the list");
    }

    public void displayAccounts() {
        if (head == null) {
            System.out.println("The list is empty");
        }
        else {
            System.out.println("The list contains the following accounts");
            Node temp = head;
            int i = 0;
            while (temp != null) {
                System.out.println(i + ". " + temp.account.username + " - Balance: " + temp.account.balance);
                i += 1;
                temp = temp.next;
            }
        }
    }

    public void searchAccount(String username) {
        Node temp = head;
        while (temp != null) {
            if (temp.account.username.equals(username)) {
                System.out.println(temp.account.accountNumber + " " + temp.account.username + " is found in the list");
                System.out.println("Balance of the account: "+temp.account.balance );

            }
        }
    }
    public BankAccount findAccount(String username) {
        Node temp = head; //
        while (temp != null) {
            if (temp.account.username.equals(username)) { //
                return temp.account;
            }
            temp = temp.next;
        }
        return null;
    }
}
