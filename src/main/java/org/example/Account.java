package org.example;

import java.util.List;

public class Account {


    private final TransactionRepo transactionRepo;
    private final TransactionService transactionService;

    private final StatementGenerator statementGenerator;

    public Account(TransactionRepo transactionRepo, TransactionService transactionService, StatementGenerator statementGenerator) {
        this.transactionRepo = transactionRepo;
        this.transactionService = transactionService;
        this.statementGenerator = statementGenerator;
    }


    void deposit(int quantity) {
        transactionRepo.add(transactionService.deposit(quantity));
    }

    void withdraw(int quantity) {
        transactionRepo.substract(transactionService.withdraw(quantity));
    }

    String printStatement() {
        List<Transaction> transactions =  transactionRepo.getHistory();
        return statementGenerator.generateWithTransactions(transactions);
    }




}