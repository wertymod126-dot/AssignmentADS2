public class ArrayTask {
    public static void main(String[] args) {
        // 1. Create array of size 3
        BankAccount[] bankArray = new BankAccount[3];

        // 2. Store 3 predefined accounts
        bankArray[0] = new BankAccount("101", "Ali", 150000);
        bankArray[1] = new BankAccount("102", "Sara", 220000);
        bankArray[2] = new BankAccount("103", "Omar", 50000);

        // 3. Print them
        System.out.println("--- Array Accounts ---");
        for (int i = 0; i < bankArray.length; i++) {
            System.out.println("ID: " + bankArray[i].accountNumber +
                    " | User: " + bankArray[i].username +
                    " | Balance: " + bankArray[i].balance);
        }
    }
}
