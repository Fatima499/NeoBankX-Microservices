package com.neobankx.account_service.controller;

import com.neobankx.account_service.model.Account;
import com.neobankx.account_service.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private  AccountService accountService;

    @GetMapping
    public List<Account> getAllAccounts(){
        return accountService.getAllAccounts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccount(@PathVariable Long id){
        return accountService.getAccountById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Account>> getAccountsByUserId(@PathVariable  Long userId) {
        List<Account> accounts = accountService.getAllAccountsByUserId(userId);
        return accounts.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(accounts);
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account){
        Account newAccount = accountService.createAccount(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(newAccount);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable Long id, @RequestBody Account updateAccount){
        return ResponseEntity.ok(accountService.updateAccount(updateAccount, id));
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> deleteAccount(@PathVariable Long id){
        accountService.deleteAccountById(id);
        return ResponseEntity.noContent().build();
    }

}
