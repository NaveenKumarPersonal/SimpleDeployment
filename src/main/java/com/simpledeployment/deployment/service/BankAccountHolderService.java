package com.simpledeployment.deployment.service;

import com.simpledeployment.deployment.dto.BankAccountRequest;
import com.simpledeployment.deployment.dto.BankAccountUpdateRequest;
import com.simpledeployment.deployment.entity.BankAccount;

public interface BankAccountHolderService {
    BankAccount createBankAccountHolder(BankAccountRequest request);

    BankAccount updateAccount(BankAccountUpdateRequest request);

    void deleteAccount(String accountId);
}
