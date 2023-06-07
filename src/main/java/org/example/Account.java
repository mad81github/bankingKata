package org.example;

import java.text.SimpleDateFormat;
import java.util.*;

public class Account {
    private int currentAmount = 0;

    private List<Transaction> history= new ArrayList<>();

    void applyQuantity(int quantity){
        currentAmount = currentAmount+quantity;
        Transaction transaction = new Transaction(new Date(),quantity,currentAmount);
        history.add(transaction);
    }

    void deposit(int quantity){
        applyQuantity(quantity);
    }
    void withdraw(int quantity) {
        if (currentAmount - quantity < 0) {
            throw new RuntimeException("No Enough amount");
        }
        applyQuantity(-quantity);

    }
    String printStatement() {
        return null;
    }

    String printLastStatement() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Transaction transaction = getLastTransaction();
        return simpleDateFormat.format(transaction.getDate())+"\t"+transaction.getAmount()+"\t"+transaction.getBalance();
    }

     Transaction getLastTransaction() {
        return history.get(history.size()-1);
     }

}