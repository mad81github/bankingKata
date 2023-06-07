package org.example;

public class TransactionService {

    private final DateBuilder dateBuilder;
    static final String DEPOSIT_OPERATION_SYMBOL = "+" ;
    static final String WITHDRAW_OPERATION_SYMBOL = "-";
    private int currentAmount = 0;

    public TransactionService(DateBuilder dateBuilder) {
        this.dateBuilder = dateBuilder;
    }

    Transaction deposit(int quantity){
        return getTransaction(quantity,DEPOSIT_OPERATION_SYMBOL);
    }

    private Transaction getTransaction(int quantity, String depositOperationSymbol) {
        currentAmount = currentAmount+ quantity;
        Transaction transaction = new Transaction(dateBuilder.getCurrentDate(), quantity,currentAmount, depositOperationSymbol);
        return transaction;
    }

    Transaction withdraw(int quantity) {
        if (currentAmount - quantity < 0) {
            throw new RuntimeException("No Enough amount");
        }
        return getTransaction(-quantity,WITHDRAW_OPERATION_SYMBOL);

    }
}
