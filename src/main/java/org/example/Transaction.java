package org.example;

import java.util.Date;

public class Transaction {

    private final Date transaction;
    private final Integer amount;
    private final Integer balance;

    public Transaction(Date transaction, Integer amount, Integer balance) {
        this.transaction = transaction;
        this.amount = amount;
        this.balance = balance;
    }

    public Date getTransaction() {
        return transaction;
    }

    public Integer getAmount() {
        return amount;
    }

    public Integer getBalance() {
        return balance;
    }
}
