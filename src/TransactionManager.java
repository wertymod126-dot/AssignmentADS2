import java.util.Stack;

public class TransactionManager {
    // 1. Create a Stack of Strings to store history
    private Stack<String> transactionHistory = new Stack<>();

    // 2. Add transaction to stack (Push)
    public void addTransaction(String action) {
        transactionHistory.push(action);
        System.out.println(action);
    }

    // 3. Display last transaction (Peek)
    public void showLastTransaction() {
        if (!transactionHistory.isEmpty()) {
            System.out.println("Last transaction: " + transactionHistory.peek());
        } else {
            System.out.println("History is empty.");
        }
    }

    // 4. Undo last transaction (Pop)
    public void undoTransaction() {
        if (!transactionHistory.isEmpty()) {
            String removed = transactionHistory.pop();
            System.out.println("Undo → " + removed + " removed");
        } else {
            System.out.println("Nothing to undo.");
        }
    }

}