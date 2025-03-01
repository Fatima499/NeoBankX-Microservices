package com.neobankx.account_service.service;

import com.neobankx.account_service.model.Account;
import com.neobankx.account_service.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public List<Account> getAllAccounts(){
        return accountRepository.findAll();
    }

    public Optional<Account> getAccountById(Long id){
        return accountRepository.findById(id);
    }

    public List<Account> getAllAccountsByUserId(Long userId){
        return accountRepository.findAllByUserId(userId);
    }

    public Account createAccount(Account account){
        return accountRepository.save(account);
    }

    public Account updateAccount(Account account, Long id) {
        account.setId(id);
        return accountRepository.save(account);
    }

    public void deleteAccountById(Long id){
        accountRepository.deleteById(id);
    }
}
