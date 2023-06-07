package org.example;

import java.text.SimpleDateFormat;
import java.util.*;

public class Account {
    static final String DEPOSIT_OPERATION_SYMBOL = "+" ;
    static final String WITHDRAW_OPERATION_SYMBOL = "-";
    private int currentAmount = 0;

    private List<Transaction> history= new ArrayList<>();

    void applyQuantity(int quantity, String operation){
        currentAmount = currentAmount+quantity;
        Transaction transaction = new Transaction(new Date(),quantity,currentAmount, operation);
        history.add(transaction);
    }

    void deposit(int quantity){
        applyQuantity(quantity, DEPOSIT_OPERATION_SYMBOL);
    }
    void withdraw(int quantity) {
        if (currentAmount - quantity < 0) {
            throw new RuntimeException("No Enough amount");
        }
        applyQuantity(-quantity,WITHDRAW_OPERATION_SYMBOL);

    }
    String printStatement() {
        String statement = "Date\tAmount\tBalance";
        for (Transaction transaction: history) {
            statement = statement + "\n"+ formatTransaction(transaction);
        }
        return statement;
    }

    String printLastStatement() {
        Transaction transaction = getLastTransaction();
        return formatTransaction(transaction);
    }

    private static String formatTransaction(Transaction transaction) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return simpleDateFormat.format(transaction.getDate()) + "\t" + transaction.getOperation() + Math.abs(transaction.getAmount()) + "\t" + transaction.getBalance();
    }

    Transaction getLastTransaction() {
        return history.get(history.size()-1);
     }

}