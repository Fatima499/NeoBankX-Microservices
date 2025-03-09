package com.neobankx.account_service.model;

import com.neobankx.account_service.enumeration.AccountType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "account_type", discriminatorType = DiscriminatorType.STRING)

@Entity
@Table(name = "accounts",  uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user_id"}, name = "unique_current_account")
})
public abstract class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private  String accountNumber;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_type", nullable = false, insertable = false, updatable = false)
    private AccountType accountType;

    public Account(BigDecimal balance, Long userId, AccountType accountType) {
        this.balance = balance;
        this.userId = userId;
        this.accountType = accountType;
    }

}
