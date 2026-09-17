package com.simpledeployment.deployment.controller;

import com.simpledeployment.deployment.dto.BankAccountRequest;
import com.simpledeployment.deployment.dto.BankAccountUpdateRequest;
import com.simpledeployment.deployment.entity.BankAccount;
import com.simpledeployment.deployment.service.BankAccountHolderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankAccountHolderController {

    private final BankAccountHolderService service;

    public BankAccountHolderController(BankAccountHolderService service) {
        this.service = service;
    }

    @PostMapping("/createAccount")
    public ResponseEntity<BankAccount> createAccount(@Valid @RequestBody BankAccountRequest request) {
        BankAccount saved = service.createBankAccountHolder(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PostMapping("/updateAccount")
    public ResponseEntity<BankAccount> updateAccount(@Valid @RequestBody BankAccountUpdateRequest request) {
        BankAccount updated = service.updateAccount(request);
        return ResponseEntity.ok(updated);
    }

    @PostMapping("/delete/{accountId}")
    public ResponseEntity<String> deleteAccount(@PathVariable String accountId) {
        service.deleteAccount(accountId);
        return ResponseEntity.ok("Account deleted successfully");
    }
}
