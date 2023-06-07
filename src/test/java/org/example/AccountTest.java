package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

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
    public void depositShouldStoreTransactionInHistory(){
        //given
        Account account = new Account();
        //when & then
        account.deposit(100);
        assertNotNull(account.getLastTransaction());
    }



}
