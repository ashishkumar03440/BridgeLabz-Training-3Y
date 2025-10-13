class Customer {
    String name;
    double balance;

    Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    void viewBalance() {
        System.out.println(name + " has balance: " + balance);
    }
}

class Bank {
    String bankName;

    Bank(String bankName) {
        this.bankName = bankName;
    }

    void openAccount(Customer c) {
        System.out.println("Account opened in " + bankName + " for " + c.name);
    }
}

public class AssociationDemo {
    public static void main(String[] args) {
        Bank bank = new Bank("SBI");
        Customer c1 = new Customer("Aman", 5000);

        bank.openAccount(c1); // Association
        c1.viewBalance();
    }
}

