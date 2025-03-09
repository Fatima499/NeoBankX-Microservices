package com.neobankx.account_service.repository;

import com.neobankx.account_service.enumeration.AccountType;
import com.neobankx.account_service.model.Account;
import com.neobankx.account_service.model.CurrentAccount;
import com.neobankx.account_service.model.SavingsAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Long> {
    List<Account> findAllByUserId(Long id);

    @Query("SELECT a FROM CurrentAccount a WHERE a.userId = :userId")
    Optional<CurrentAccount> findCurrentAccountByUserId(Long userId, AccountType accountType);

    @Query("SELECT a FROM SavingsAccount a WHERE a.userId = :userId")
    List<SavingsAccount> findSavingsAccountByUserId(Long userId, AccountType accountType);
}
