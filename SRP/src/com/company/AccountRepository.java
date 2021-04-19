package com.company;

import java.util.ArrayList;
import java.util.List;

public class AccountRepository {

    public List<Account> accountsList=new ArrayList<>();;

    public void addAccount(Account account)
    {
        accountsList.add(account);
    }

    public Account getById(int id)
    {
        return accountsList.get(id);
    }
}