package org.example;

import java.util.Date;

public class Transaction {

    private final Date date;
    private final Integer amount;
    private final Integer balance;

    public Transaction(Date date, Integer amount, Integer balance) {
        this.date = date;
        this.amount = amount;
        this.balance = balance;
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
}
