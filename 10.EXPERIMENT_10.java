abstract class BankAccount {
    private int accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(int accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    abstract double calculateInterest();

    public void displayDetails() {
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHolderName);
        System.out.println("Balance        : " + balance);
    }
}

class SavingsAccount extends BankAccount {

    public SavingsAccount(int accountNumber, String accountHolderName, double balance) {
        super(accountNumber, accountHolderName, balance);
    }

    @Override
    double calculateInterest() {
        return getBalance() * 0.04;
    }
}

class CurrentAccount extends BankAccount {

    public CurrentAccount(int accountNumber, String accountHolderName, double balance) {
        super(accountNumber, accountHolderName, balance);
    }

    @Override
    double calculateInterest() {
        return getBalance() * 0.01;
    }
}

public class BankManagementSystem {
    public static void main(String[] args) {

        SavingsAccount sa = new SavingsAccount(101, "Mohammad Zaid", 10000);
        CurrentAccount ca = new CurrentAccount(201, "Ali Khan", 20000);

        sa.deposit(5000);
        ca.deposit(3000);

        System.out.println("----- Savings Account -----");
        sa.displayDetails();
        System.out.println("Interest : " + sa.calculateInterest());

        System.out.println();

        System.out.println("----- Current Account -----");
        ca.displayDetails();
        System.out.println("Interest : " + ca.calculateInterest());
    }
}