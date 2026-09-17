package com.simpledeployment.deployment.service.impl;

import com.simpledeployment.deployment.dto.BankAccountRequest;
import com.simpledeployment.deployment.dto.BankAccountUpdateRequest;
import com.simpledeployment.deployment.entity.BankAccount;
import com.simpledeployment.deployment.repository.BankAccountHolderRepository;
import com.simpledeployment.deployment.service.BankAccountHolderService;
import com.simpledeployment.deployment.util.CommonUtil;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class BankAccountHolderServiceImpl implements BankAccountHolderService {

    private final BankAccountHolderRepository repository;
    public BankAccountHolderServiceImpl(BankAccountHolderRepository repository) {
        this.repository = repository;
    }

    @Override
    public BankAccount createBankAccountHolder(BankAccountRequest request) {
        if (repository.existsByAccountNumber(request.getAccountNumber())) {
            throw new IllegalArgumentException("Account number already exists");
        }

        BankAccount account = new BankAccount();
        account.setHolderName(request.getHolderName());
        account.setAccountType(request.getAccountType());
        account.setAccountNumber(request.getAccountNumber());
        account.setIfscCode(request.getIfscCode());
        account.setBranchName(request.getBranchName());
        account.setTotalBalance(request.getTotalBalance());
        account.setAccountId(CommonUtil.generateRandomAlphaNumeric(8));

        return repository.save(account);
    }

    @Override
    public BankAccount updateAccount(BankAccountUpdateRequest request) {
        BankAccount account = repository.findByAccountId(request.getAccountId())
                .orElseThrow(() -> new NoSuchElementException("Account not found: " + request.getAccountId()));

        account.setHolderName(request.getHolderName());
        account.setAccountType(request.getAccountType());
        account.setBranchName(request.getBranchName());
        account.setTotalBalance(request.getTotalBalance());
        account.setIfscCode(request.getIfscCode());

        return repository.save(account);
    }

    @Override
    public void deleteAccount(String accountId) {
        BankAccount account = repository.findByAccountId(accountId)
                .orElseThrow(() -> new NoSuchElementException("Account not found"));
        repository.delete(account);
    }
}
