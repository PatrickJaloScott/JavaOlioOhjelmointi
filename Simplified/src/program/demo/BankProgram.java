package program.demo;

import model.BankAccount;

public class BankProgram {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(1000);
        BankAccount account2 = new BankAccount(2000);

        account1.deposit(500);
        account2.withdraw(800);

        System.out.println(account1);
        System.out.println(account2);

        System.out.println("Total number of accounts: " + BankAccount.getTotalAccounts());
    }
}
