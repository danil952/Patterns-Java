package com.company;

import java.awt.event.ActionEvent;
import java.util.List;

public class Example1 {

    public static void main(String[] args) {

        Account acc1 = new Account("Danil");
        Account acc2 = new Account("Bulat");
        AccountRepository rep = new AccountRepository();
        rep.addAccount(acc1);
        rep.addAccount(acc2);
        System.out.println(rep.getById(0).name);


    }
}
