
package com.example.banking;

public class BankAccount {

    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (amount > balance) {
            throw new IllegalStateException("Insufficient balance");
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        System.out.println("Initial Balance: " + account.getBalance());

        account.deposit(500);
        System.out.println("After Deposit: " + account.getBalance());

        account.withdraw(200);
        System.out.println("After Withdrawal: " + account.getBalance());

        System.out.println("Current Balance: " + account.getBalance());
    }
}
