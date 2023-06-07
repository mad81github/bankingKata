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
        return null;
    }

    String printLastStatement() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Transaction transaction = getLastTransaction();
        return simpleDateFormat.format(transaction.getDate())+"\t"+transaction.getOperation()+transaction.getAmount()+"\t"+transaction.getBalance();
    }

     Transaction getLastTransaction() {
        return history.get(history.size()-1);
     }

}