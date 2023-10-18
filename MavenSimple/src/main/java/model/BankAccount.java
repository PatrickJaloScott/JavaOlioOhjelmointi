package model;

public class BankAccount {
    private final int accountNumber;
    private static int lastAccountNumber = 0;
    private double balance;

    public BankAccount(double balance) {
        this.accountNumber = ++lastAccountNumber;
        this.balance = balance;
    }

    public double getBalance() {
        return this.balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    @Override
    public String toString() {
        return "Account " + accountNumber + " balance: " + getBalance();
    }

    public static int getTotalAccounts() {
        return lastAccountNumber;
    }
}
