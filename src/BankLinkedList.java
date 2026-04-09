class BankLinkedList {
    //task 1
    private Node head;

    public void addAccount(String name,double bal,int id) {
        BankAccount newAcc = new BankAccount( name, bal, id);
        Node newNode = new Node(newAcc);

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Account added successfully");
    }

    // Method to display all accounts
    public void displayAccounts() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        System.out.println("Accounts List:");
        Node temp = head;
        int i = 1;
        while (temp != null) {
            System.out.println(i + ". " + temp.account.username + " – Balance: " + temp.account.balance);
            temp = temp.next;
            i++;
        }
    }

    // Method to search by username
    public void searchAccount(String name) {
        Node temp = head;
        while (temp != null) {
            if (temp.account.username.equalsIgnoreCase(name)) {
                System.out.println("Found: " + temp.account.username + " | ID: " + temp.account.accountNumber + " | Balance: " + temp.account.balance);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Account not found.");
    }

    // Task 2 from here

    // 1. Deposit Operation
    public void deposit(String name, double amount) {
        Node temp = head;
        while (temp != null) {
            if (temp.account.username.equalsIgnoreCase(name)) {
                // Update the balance directly in the node
                temp.account.balance += amount;
                System.out.println("Deposit: " + amount);
                System.out.println("New balance: " + temp.account.balance);
                return; // Exit after updating
            }
            temp = temp.next;
        }
        System.out.println("Account not found.");
    }

    // 2. Withdraw Operation
    public void withdraw(String name, double amount) {
        Node temp = head;
        while (temp != null) {
            if (temp.account.username.equalsIgnoreCase(name)) {
                if (temp.account.balance >= amount) {
                    temp.account.balance -= amount;
                    System.out.println("Withdraw: " + amount);
                    System.out.println("New balance: " + temp.account.balance);
                } else {
                    System.out.println("Insufficient funds!");
                }
                return;
            }
            temp = temp.next;
        }
        System.out.println("Account not found.");
    }

}