package ThisStaticFinalKeywords;

public class BankAccount {
    static String bankName = "ABC Bank";
    static int totalAccounts = 0;
    final String accountNumber;
    String accountHolderName;

    BankAccount(String accountHolderName, String accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        totalAccounts++;
    }

    static void getTotalAccounts() {
        System.out.println(totalAccounts);
    }

    void displayDetails() {
        if (this instanceof BankAccount) {
            System.out.println(bankName + " " + accountHolderName + " " + accountNumber);
        }
    }

    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("Rahul", "123");
        BankAccount acc2 = new BankAccount("Simran", "456");
        acc1.displayDetails();
        acc2.displayDetails();
        BankAccount.getTotalAccounts();
    }
}
