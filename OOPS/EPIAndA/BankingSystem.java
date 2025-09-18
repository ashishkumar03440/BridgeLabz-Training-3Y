package EPIAndA;

// File: KeywordsAndOperators/BankingSystem.java

import java.util.*;

// Abstract class BankAccount
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Encapsulation: Getters and Setters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    // Concrete methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " deposited. New Balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println(amount + " withdrawn. Remaining Balance: " + balance);
        } else {
            System.out.println("Insufficient balance or invalid withdrawal amount.");
        }
    }

    // Abstract method
    public abstract double calculateInterest();

    // Common details display
    public void displayAccountDetails() {
        System.out.println("Account No : " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance    : " + balance);
    }
}

// Loanable interface
interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

// SavingsAccount subclass
class SavingsAccount extends BankAccount implements Loanable {
    private static final double INTEREST_RATE = 0.04; // 4% annual

    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * INTEREST_RATE;
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Savings Account Loan Requested: " + amount);
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() >= 5000;
    }
}

// CurrentAccount subclass
class CurrentAccount extends BankAccount implements Loanable {
    private static final double INTEREST_RATE = 0.02; // 2% annual

    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * INTEREST_RATE;
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Current Account Loan Requested: " + amount);
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() >= 10000;
    }
}

// Main class
public class BankingSystem {
    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();

        // Create accounts
        BankAccount savings = new SavingsAccount("SAV101", "Alice", 8000);
        BankAccount current = new CurrentAccount("CUR202", "Bob", 15000);

        accounts.add(savings);
        accounts.add(current);

        // Demonstrating polymorphism
        for (BankAccount acc : accounts) {
            acc.displayAccountDetails();
            double interest = acc.calculateInterest();
            System.out.println("Calculated Interest: " + interest);

            if (acc instanceof Loanable) {
                Loanable loanAcc = (Loanable) acc;
                loanAcc.applyForLoan(5000);
                System.out.println("Loan Eligibility: " + loanAcc.calculateLoanEligibility());
            }
            System.out.println("----------------------------------");
        }

        // Testing transactions
        savings.deposit(2000);
        savings.withdraw(1000);

        current.withdraw(20000); // will fail due to insufficient balance
    }
}

