package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Write a class Account that offers the following methods void deposit(int) void withdraw(int) String printStatement()
 */
public class AccountTest {



    @Test
    public void withdrawWithoutFoundsShouldRaiseError(){
        //given
        Account account = new Account();
        //when & then
        Assertions.assertThrows(Exception.class,
                () -> account.withdraw(1));
    }


}
