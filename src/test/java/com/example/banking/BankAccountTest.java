
package com.example.banking;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class BankAccountTest {

    @Test
    void testDepositAndWithdrawal() {
        BankAccount account = new BankAccount(1000);
        account.deposit(500);
        account.withdraw(200);
        assertEquals(1300, account.getBalance());
    }

    @Test
    void testInsufficientBalance() {
        BankAccount account = new BankAccount(500);
        assertThrows(IllegalStateException.class, () -> account.withdraw(600));
        assertEquals(500, account.getBalance());
    }

    @Test
    void testZeroAndNegativeAmounts() {
        BankAccount account = new BankAccount(1000);

        assertThrows(IllegalArgumentException.class, () -> account.deposit(0));
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-100));
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(0));
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-100));

        assertEquals(1000, account.getBalance());
    }

    @Test
    void testMultipleTransactions() {
        BankAccount account = new BankAccount(1000);
        account.deposit(500);
        account.withdraw(200);
        account.deposit(100);
        account.withdraw(50);

        assertEquals(1350, account.getBalance());
    }
}
