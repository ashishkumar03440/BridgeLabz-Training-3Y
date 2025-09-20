package OOPS.Inheritance;

class BankAccount {
    String accountNumber;
    double balance;

    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
}

class SavingsAccount extends BankAccount {
    double interestRate;

    SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    void displayAccountType() {
        System.out.println("Savings Account - Interest: " + interestRate + "%");
    }
}

class CheckingAccount extends BankAccount {
    double withdrawalLimit;

    CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    void displayAccountType() {
        System.out.println("Checking Account - Withdrawal Limit: " + withdrawalLimit);
    }
}

class FixedDepositAccount extends BankAccount {
    int term; // months

    FixedDepositAccount(String accountNumber, double balance, int term) {
        super(accountNumber, balance);
        this.term = term;
    }

    void displayAccountType() {
        System.out.println("Fixed Deposit Account - Term: " + term + " months");
    }
}

public class BankDemo {
    public static void main(String[] args) {
        BankAccount b1 = new SavingsAccount("SAV123", 10000, 4.5);
        BankAccount b2 = new CheckingAccount("CHK456", 5000, 1000);
        BankAccount b3 = new FixedDepositAccount("FD789", 20000, 12);

        ((SavingsAccount)b1).displayAccountType();
        ((CheckingAccount)b2).displayAccountType();
        ((FixedDepositAccount)b3).displayAccountType();
    }
}
