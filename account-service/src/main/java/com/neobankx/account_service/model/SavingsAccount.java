package com.neobankx.account_service.model;

import com.neobankx.account_service.enumeration.AccountType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name="savings_accounts")
@DiscriminatorValue("SAVINGS")
@PrimaryKeyJoinColumn(name = "id")
@NoArgsConstructor
@AllArgsConstructor
public class SavingsAccount extends Account {

    private BigDecimal interestRate;

    public SavingsAccount(BigDecimal balance, Long userId, BigDecimal interestRate) {
        super(balance, userId, AccountType.SAVINGS);
        this.interestRate = interestRate;
    }
}
