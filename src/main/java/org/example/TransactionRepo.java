package org.example;

import java.util.List;

public interface TransactionRepo {
    void add(Transaction transaction);

    List<Transaction> getHistory();

    void substract(Transaction transaction);
}
