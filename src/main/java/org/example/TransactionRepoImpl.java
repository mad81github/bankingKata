package org.example;

import java.util.ArrayList;
import java.util.List;

public class TransactionRepoImpl implements TransactionRepo{

    List<Transaction> history = new ArrayList<>();

    @Override
    public void add(Transaction transaction) {
        history.add(transaction);
    }

    @Override
    public List<Transaction> getHistory() {
        return history;
    }

    @Override
    public void substract(Transaction transaction) {
        history.add(transaction);
    }
}
