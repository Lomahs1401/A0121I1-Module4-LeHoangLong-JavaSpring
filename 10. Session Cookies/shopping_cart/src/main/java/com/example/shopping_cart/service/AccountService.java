package com.example.shopping_cart.service;

import java.util.List;

import com.example.shopping_cart.model.Account;

public interface AccountService {
    public List<Account> findAllAccount();
    public Account findAccountByUsername(String username);
    public void saveOrUpdate(Account account);
    public void removeAccount(Account account);
    public void removeAccountByUsername(String username);
    public boolean isExist(Account account);
}
