package com.example.shopping_cart.service.impl;

import java.util.List;

import com.example.shopping_cart.model.Account;
import com.example.shopping_cart.repository.AccountRepository;
import com.example.shopping_cart.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public List<Account> findAllAccount() {
        return accountRepository.findAll();
    }

    @Override
    public Account findAccountByUsername(String username) {
        for (Account account : findAllAccount()) {
            if (account.getUsername().equals(username)) {
                return account;
            }
        }
        return null;
    }

    @Override
    public void saveOrUpdate(Account account) {
        if (findAccountByUsername(account.getUsername()) == null) {
            accountRepository.save(account);
        } else {
            accountRepository.update(account.getUsername(), account.getPassword(), 
            account.getFullname(), account.getEmail(), account.getPhoto(), 
            account.getActivated(), account.getAdmin());
        }
    }

    @Override
    public void removeAccount(Account account) {
        accountRepository.delete(account);
    }

    @Override
    public void removeAccountByUsername(String username) {
        accountRepository.deleteById(username);
    }

    @Override
    public boolean isExist(Account account) {
        return accountRepository.existsById(account.getUsername());
    }
}
