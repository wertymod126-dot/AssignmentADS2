public class AdminSimulation {
    private AccReqNode front;
    private AccReqNode rear;
    private BankLinkedList mainSystem = new BankLinkedList();

    class AccountRequest {
        String accountID;
        double initialbalance;
        String username;

        public AccountRequest(String accountID, double initialbalance, String username) {
            this.accountID = accountID;
            this.initialbalance = initialbalance;
            this.username = username;
        }
    }

    public void submitAccountRequest(String accountID, double initialbalance, String username) {
        AccountRequest requestedAcc = new AccountRequest(accountID, initialbalance, username);
        AccReqNode accNode = new AccReqNode(requestedAcc);
        if (rear == null) {
            rear = front = accNode;
        }
        else {
            rear.next = accNode;
            rear = rear.next;
        }
        System.out.println("New account request has been submitted");
    }
    public void processRequest(String request) {
        if (front == null) {
            System.out.println("No requests");
            return;
        }
        else {
            AccountRequest ReqToProcess = front.request;
            front = front.next;

            if (front == null) {
                rear = null;
            }

            mainSystem.addAccount(ReqToProcess.accountID,ReqToProcess.username,ReqToProcess.initialbalance);

            System.out.println("Account has been added to the main system.");
        }
    }

    public void displayRequests() {
        if (front == null) {
            System.out.println("No requests");
        }
        else {
            System.out.println("--------Account Requests-------");
            AccReqNode temp = front;
            while (temp != null) {
                System.out.println("User: " + temp.request.username + " | ID: " + temp.request.accountID + " | Balance: " + temp.request.initialbalance);
                temp = temp.next;
            }
        }
    }

}

