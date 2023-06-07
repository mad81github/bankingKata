package org.example;

public class Transaction {

    private final String date;
    private final Integer amount;
    private final Integer balance;

    private final String operation;

    public Transaction(String date, Integer amount, Integer balance, String operation) {
        this.date = date;
        this.amount = amount;
        this.balance = balance;
        this.operation = operation;
    }

    public String getDate() {
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
