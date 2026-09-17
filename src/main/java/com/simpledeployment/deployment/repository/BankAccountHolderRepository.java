package com.simpledeployment.deployment.repository;

import com.simpledeployment.deployment.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankAccountHolderRepository extends JpaRepository<BankAccount, Long> {
    boolean existsByAccountNumber(String accountNumber);
    boolean existsByAccountId(String accountId);
    Optional<BankAccount> findByAccountId(String accountId);
    void deleteByAccountId(String accountId);
}
