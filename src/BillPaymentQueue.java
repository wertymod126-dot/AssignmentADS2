public class BillPaymentQueue {
    private BillNode front;
    private BillNode rear;

    public BillPaymentQueue() {
        this.front = null;
        this.rear = null;
    }

    public void addBill(String name) {
        BillNode newNode = new BillNode(name);

        if (this.rear == null) {
            this.rear = this.front = new BillNode(name);
        }
        else {
            this.rear.next = newNode;
            this.rear = newNode;
        }
        System.out.print("Added bill: " + name);
    }

    public void processBill() {
        if (this.front == null) {
            System.out.println("No bills in queue");
        }
        else {
            System.out.print("Processing: " + this.front.billname);
            this.front = this.front.next;

            if (this.front == null) {
                this.rear = null;
                System.out.println("There is now no bills in the queue");
            }

        }
    }

    public void displayBills() {
        if (this.front == null) {
            System.out.println("No bills in queue");
        }
        else {
            System.out.print("Current Bills in the queue:\n");
            BillNode temp = this.front;
            while (temp != null) {
                System.out.print(temp.billname);
                temp = temp.next;
            }
        }
    }
}
