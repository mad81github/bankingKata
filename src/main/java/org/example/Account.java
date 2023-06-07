package org.example;

import java.util.*;

public class Account {
    private int currentAmount = 0;

    private List<Transaction> history= new ArrayList<>();

    void deposit(int quantity){


    }
    void withdraw(int quantity) throws Exception {
        if (currentAmount - quantity < 0) {
            throw new Exception("No Enough amount");
        }
    }
    String printStatement() {

        return null;
    }

     Transaction getLastTransaction() {
        return history.get(history.size()-1);
     }

}