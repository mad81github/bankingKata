package org.example;


import static org.example.TransactionService.DEPOSIT_OPERATION_SYMBOL;
import static org.example.TransactionService.WITHDRAW_OPERATION_SYMBOL;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

/**
 * Write a class Account that offers the
 * following methods void deposit(int)
 * void withdraw(int) String printStatement()
 */
public class AccountTest {

    public static final String CURRENT_DATE = "21.05.2023";
    Account genericAccount;
    private TransactionRepo transactionRepo;
    private DateBuilder dateBuilder;

    private TransactionService transactionService;
    private StatementGenerator statementGenerator;

    @BeforeEach
    public void setUp(){
        statementGenerator = new StatementGenerator();
        transactionRepo = spy(new TransactionRepoImpl());
        dateBuilder = spy(DateBuilder.class);
        transactionService = new TransactionService(dateBuilder);
        genericAccount = new Account(transactionRepo, transactionService, statementGenerator);
        when(dateBuilder.getCurrentDate()).thenReturn(CURRENT_DATE);

    }


    @Test
    public void withdrawWithInsufficientFundsShouldRaiseError(){
        //given
        Account account = new Account(transactionRepo, transactionService, statementGenerator);
        //when & then
        assertThrows(Exception.class,
                () -> account.withdraw(1));
    }




    @Test
    public void depositShouldStoreTransactionInHistoryWithDateAndCurrentBalanceAddingQuantiyAndOperation(){
        //given
        Account account = new Account(transactionRepo, transactionService, statementGenerator);
        //when
        account.deposit(100);
        //then
        ArgumentCaptor<Transaction> argumentCaptor = ArgumentCaptor.forClass(Transaction.class);
        verify(transactionRepo).add(argumentCaptor.capture());
        Transaction transaction = argumentCaptor.getValue();
        assertEquals(100,transaction.getAmount());
        assertEquals(100,transaction.getBalance());
        assertEquals(DEPOSIT_OPERATION_SYMBOL,transaction.getOperation());
        assertEquals(CURRENT_DATE,transaction.getDate());
    }


    @Test
    public void withDrawShouldStoreTransactionInHistoryWithDateAndCurrentBalanceSubtractQuantityAndOperation()  {
        //given
        Account account = new Account(transactionRepo,transactionService, statementGenerator);
        account.deposit(1000);

        //when
        account.withdraw(100);
        //then
        ArgumentCaptor<Transaction> argumentCaptor = ArgumentCaptor.forClass(Transaction.class);
        verify(transactionRepo).substract(argumentCaptor.capture());
        Transaction transaction = argumentCaptor.getValue();
        assertEquals(-100,transaction.getAmount());
        assertEquals(900,transaction.getBalance());
        assertEquals(WITHDRAW_OPERATION_SYMBOL,transaction.getOperation());
        assertEquals(CURRENT_DATE,transaction.getDate());
    }





    @Test
    public void printStatementWhenDepositAndWithDrawAndShouldReturnStatementFormatted() {
        //when
        genericAccount.deposit(500);
        genericAccount.withdraw(100);



        //then

        assertEquals(
                "Date\tAmount\tBalance\n"
                + CURRENT_DATE+"\t+500\t500\n"
                + CURRENT_DATE+"\t-100\t400",
                genericAccount.printStatement());

    }



}
