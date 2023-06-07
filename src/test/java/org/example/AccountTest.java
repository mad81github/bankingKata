package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 * Write a class Account that offers the
 * following methods void deposit(int)
 * void withdraw(int) String printStatement()
 */
public class AccountTest {



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
        assertTrue(account.getLastTransaction().getDate().after(dateBeforeDeposit));
        assertTrue(account.getLastTransaction().getDate().compareTo(dateBeforeDeposit)>=0);
        assertTrue(account.getLastTransaction().getDate().compareTo(dateAfterDeposit)<=0);
    }




}
