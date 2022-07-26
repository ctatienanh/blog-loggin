package com.codegym.service;

import com.codegym.models.Account;
import com.codegym.repository.IAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class AccountService {
    @Autowired
    IAccount iAccount;
    public List<Account> getall(){
        return (List<Account>) iAccount.findAll();
    }
    public void create(Account account){
        iAccount.save(account);
    }
}
