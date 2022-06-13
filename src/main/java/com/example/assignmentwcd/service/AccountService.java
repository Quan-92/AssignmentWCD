package com.example.assignmentwcd.service;

import com.example.assignmentwcd.entity.Account;
import com.example.assignmentwcd.model.AccountModel;
import com.example.assignmentwcd.model.sqlmodel.MySqlAccountModel;
import com.example.assignmentwcd.util.SHA512Hasher;

public class AccountService {
    private final AccountModel accountModel;

    public AccountService() {
        this.accountModel = new MySqlAccountModel();
    }

    public Account register(Account account) {
        String salt = SHA512Hasher.randomString(7);
        String passwordHashed = SHA512Hasher.encode(account.getPassword(), salt);
        account.setPassword(passwordHashed + "." + salt);
        accountModel.Save(account);
        return account;
    }

    public Account login(String phone, String password) {
        Account accountFound = accountModel.findByPhone(phone);
        if (accountFound == null) {
            return null;
        }
        if (SHA512Hasher.checkPassword(accountFound.getPassword(), password)) {
            return accountFound;
        }
        return null;
    }

}
