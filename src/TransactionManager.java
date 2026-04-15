import java.util.Stack;

public class TransactionManager {
    private Stack<String> TransactionHistory = new Stack<>();

    public void addTransaction(String transaction) {
        TransactionHistory.push(transaction);
        System.out.println(transaction);
    }
    public void lastTransaction() {
        if (!TransactionHistory.isEmpty()) {
            System.out.println(TransactionHistory.peek());
        }
        else  {
            System.out.println("No transactions found");
        }
    }

    public void undoTransaction() {
        if (!TransactionHistory.isEmpty()) {
            String removedTransaction = TransactionHistory.pop();
            System.out.println("transaction removed: " + removedTransaction);
        }
        else {
            System.out.println("No transactions found");
        }
    }

}
