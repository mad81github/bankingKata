package org.example;

import java.util.HashMap;
import java.util.Map;

public class Account {
    private int currentAmount = 0;

   Map<String, Map.Entry<Integer,Integer>> history= new HashMap<>();

    void deposit(int quantity){


    }
    void withdraw(int quantity) throws Exception {
        if (currentAmount - quantity < 0) {
            throw new Exception("No Enough amount");
        }
    }
    String printStatement() {

        return null;
    }
}