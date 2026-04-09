import java.util.LinkedList;
import java.util.Queue;

public class AdminSimulation {
    //Task 5
    // 1. The Queue for pending requests
    private Queue<AccountRequest> accountRequests = new LinkedList<>();

    // 2. The main LinkedList for approved accounts (from Task 1)
    private BankLinkedList mainSystem = new BankLinkedList();

    // Helper class to store request data temporarily
    class AccountRequest {
        String name;
        double initialDeposit;
        int id;

        AccountRequest(String name, double initialDeposit, int id) {
            this.name = name;
            this.initialDeposit = initialDeposit;
            this.id = id;
        }
    }

    // Method: User submits a request
    public void submitRequest(String name, double deposit, int id) {
        accountRequests.add(new AccountRequest(name, deposit, id));
        System.out.println("Request Added to Queue: " + name);
    }

    // Method: Admin processes the NEXT request in line
    public void processNextRequest() {
        if (!accountRequests.isEmpty()) {
            // Remove from Queue (FIFO)
            AccountRequest request = accountRequests.poll();

            // Move to the permanent LinkedList
            mainSystem.addAccount(request.name, request.initialDeposit, request.id);

            System.out.println("Processing: " + request.name + " - Moved to Main System.");
        } else {
            System.out.println("No pending requests to process.");
        }
    }

    // Method: Display pending requests
    public void displayPending() {
        System.out.println("\n--- Pending Account Requests ---");
        if (accountRequests.isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            for (AccountRequest req : accountRequests) {
                System.out.println("User: " + req.name + " | Deposit: " + req.initialDeposit);
            }
        }
    }

    public static void main(String[] args) {
        AdminSimulation admin = new AdminSimulation();

        // Users applying
        admin.submitRequest("John Doe", 5000.0, 103);
        admin.submitRequest("Jane Smith", 12000.0, 104);

        admin.displayPending();

        // Admin approving the first person in line (John Doe)
        admin.processNextRequest();

        // Showing the permanent system
        admin.mainSystem.displayAccounts();
    }
}