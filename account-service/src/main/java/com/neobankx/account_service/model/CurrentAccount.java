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
@Table(name = "current_accounts")
@DiscriminatorValue("CURRENT")
@PrimaryKeyJoinColumn(name = "id")
@NoArgsConstructor
@AllArgsConstructor
public class CurrentAccount extends Account {

    private BigDecimal overdraft;

    public CurrentAccount(BigDecimal balance, Long userId, BigDecimal overdraft){
        super(balance, userId, AccountType.CURRENT);
        this.overdraft = overdraft;
    }
}
