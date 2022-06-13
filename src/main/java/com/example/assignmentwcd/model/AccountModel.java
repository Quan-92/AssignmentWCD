package com.example.assignmentwcd.model;

import com.example.assignmentwcd.entity.Account;

import java.util.List;

public interface AccountModel {
    boolean Save(Account account);

    List<Account> getAll();

    Account findById(int id);

    Account findByPhone(String phone);

    boolean Update(int id, Account updateAccount);

    boolean Delete(int id);
}
