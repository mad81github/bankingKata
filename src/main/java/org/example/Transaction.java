package org.example;

import java.util.Date;

public class Transaction {

    private final Date date;
    private final Integer amount;
    private final Integer balance;

    private final String operation;

    public Transaction(Date date, Integer amount, Integer balance, String operation) {
        this.date = date;
        this.amount = amount;
        this.balance = balance;
        this.operation = operation;
    }

    public Date getDate() {
        return date;
    }

    public Integer getAmount() {
        return amount;
    }

    public Integer getBalance() {
        return balance;
    }

    public String getOperation() {
        return operation;
    }
}
