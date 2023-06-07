package org.example;

import java.util.*;

public class Account {
    private int currentAmount = 0;

    private List<Transaction> history= new ArrayList<>();

    void deposit(int quantity){
        currentAmount = currentAmount+quantity;

        Transaction transaction = new Transaction(new Date(),quantity,currentAmount);
        history.add(transaction);
    }
    void withdraw(int quantity) {
        if (currentAmount - quantity < 0) {
            throw new RuntimeException("No Enough amount");
        }
        currentAmount = currentAmount-quantity;
        Transaction transaction = new Transaction(new Date(),quantity,currentAmount);
        history.add(transaction);

    }
    String printStatement() {

        return null;
    }

     Transaction getLastTransaction() {
        return history.get(history.size()-1);
     }

}