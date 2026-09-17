package com.simpledeployment.deployment.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "accounts")
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String holderName;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    private String accountNumber;
    private String ifscCode;
    private String branchName;
    @Column(unique = true, nullable = false, updatable = false)
    private String accountId;
    @Column(precision = 15, scale = 2)
    private BigDecimal totalBalance;
    @CreationTimestamp
    @Column(name = "created_date", updatable = false)
    private LocalDateTime createdDate;
    @UpdateTimestamp
    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    public enum AccountType {
        SAVINGS, CURRENT, FIXED_DEPOSIT
    }
}
