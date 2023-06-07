package org.example;

import static org.example.Account.DEPOSIT_OPERATION_SYMBOL;
import static org.example.Account.WITHDRAW_OPERATION_SYMBOL;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Write a class Account that offers the
 * following methods void deposit(int)
 * void withdraw(int) String printStatement()
 */
public class AccountTest {

    Account genericAccount;

    @BeforeEach
    public void setUp(){
        genericAccount = new Account();
    }



    @Test
    public void withdrawWithoutFoundsShouldRaiseError(){
        //given
        Account account = new Account();
        //when & then
        assertThrows(Exception.class,
                () -> account.withdraw(1));
    }

    @Test
    public void getLastTransactionShouldRaiseErrorWhenHistoryIsEmpty(){
        //given
        Account account = new Account();
        //when & then
        assertThrows(Exception.class,
                () -> account.getLastTransaction());
    }

    @Test
    public void depositShouldStoreTransactionInHistoryWithDateAndCurrentBalance(){
        //given
        Date dateBeforeDeposit = new Date();
        Account account = new Account();
        //when
        account.deposit(100);
        //then
        Date dateAfterDeposit = new Date();
        assertNotNull(account.getLastTransaction());
        assertEquals(100,account.getLastTransaction().getAmount());
        assertEquals(100,account.getLastTransaction().getBalance());
        assertDateTransaction(dateBeforeDeposit, account, dateAfterDeposit);
    }

    private static void assertDateTransaction(Date dateBeforeDeposit, Account account, Date dateAfterDeposit) {
        assertTrue(account.getLastTransaction().getDate().compareTo(dateBeforeDeposit)>=0);
        assertTrue(account.getLastTransaction().getDate().compareTo(dateAfterDeposit)<=0);
    }

    @Test
    public void depositShouldStoreTransactionInHistoryWithDateAndCurrentBalanceAddingQuantiyAndOperation(){
        //given
        Date dateBeforeDeposit = new Date();
        Account account = new Account();
        account.deposit(1000);

        //when
        account.deposit(100);
        //then
        Date dateAfterDeposit = new Date();
        assertNotNull(account.getLastTransaction());
        assertEquals(100,account.getLastTransaction().getAmount());
        assertEquals(DEPOSIT_OPERATION_SYMBOL,account.getLastTransaction().getOperation());
        assertEquals(1100,account.getLastTransaction().getBalance());
        assertDateTransaction(dateBeforeDeposit, account, dateAfterDeposit);
    }


    @Test
    public void withDrawShouldStoreTransactionInHistoryWithDateAndCurrentBalanceSubtractQuantityAndOperation()  {
        //given
        Account account = new Account();
        account.deposit(1000);
        Date dateBeforeWithdraw = new Date();

        //when
        account.withdraw(100);
        //then
        Date dateAfterDeposit = new Date();
        assertNotNull(account.getLastTransaction());
        assertEquals(-100,account.getLastTransaction().getAmount());
        assertEquals(900,account.getLastTransaction().getBalance());
        assertEquals(WITHDRAW_OPERATION_SYMBOL,account.getLastTransaction().getOperation());
        assertDateTransaction(dateBeforeWithdraw, account, dateAfterDeposit);
    }

    @Test
    public void whenDepositAndPrintLastStatementShouldReturnLastTransactionFormatted() {
        //when
        genericAccount.deposit(100);
        //then
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        simpleDateFormat.format(new Date());
        assertEquals(simpleDateFormat.format(new Date())+"\t+100\t100",genericAccount.printLastStatement());

    }

    @Test
    public void whenWithDrawAndPrintLastStatementShouldReturnLastTransactionFormatted() {
        //when
        genericAccount.deposit(1000);
        genericAccount.withdraw(500);
        //then
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        simpleDateFormat.format(new Date());
        assertEquals(simpleDateFormat.format(new Date())+"\t-500\t500",genericAccount.printLastStatement());

    }

    @Test
    public void printStatementWhenDepositAndWithDrawAndShouldReturnStatementFormatted() {
        //when
        genericAccount.deposit(500);
        genericAccount.withdraw(100);

        //then
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String dateFormatted = simpleDateFormat.format(new Date());

        assertEquals(
                "Date\tAmount\tBalance\n"
                + dateFormatted+"\t+500\t500\n"
                + dateFormatted+"\t-100\t400",
                genericAccount.printStatement());

    }



}
