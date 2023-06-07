package org.example;

import java.util.List;

public class StatementGenerator {

    public String generateWithTransactions(List<Transaction> transactions) {
        String statement = "Date\tAmount\tBalance";
        for (Transaction transaction: transactions) {
            statement = statement + "\n"+ formatTransaction(transaction);
        }
        return statement;
    }

    private  String formatTransaction(Transaction transaction) {
        return transaction.getDate()+ "\t" + transaction.getOperation() + Math.abs(transaction.getAmount()) + "\t" + transaction.getBalance();
    }
}
