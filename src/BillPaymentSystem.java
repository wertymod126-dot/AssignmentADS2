import java.util.LinkedList;
import java.util.Queue;

public class BillPaymentSystem {
    //task 4
    public static void main(String[] args) {
        // 1. Create a Queue using LinkedList
        Queue<String> billQueue = new LinkedList<>();

        // 2. Add bill payment requests (Enqueue)
        billQueue.add("Electricity Bill");
        System.out.println("Added: Electricity Bill");

        billQueue.add("Internet Bill");
        System.out.println("Added: Internet Bill");

        billQueue.add("Water Bill");
        System.out.println("Added: Water Bill");

        // 3. Display the queue
        System.out.println("\nCurrent Queue: " + billQueue);

        // 4. Process the next bill (Dequeue)
        if (!billQueue.isEmpty()) {
            // poll() removes the head of the queue (the first one added)
            String processed = billQueue.poll();
            System.out.println("\nProcessing: " + processed);
        }

        // 5. Display remaining
        System.out.println("Remaining: " + billQueue);
    }
}