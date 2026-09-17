package com.simpledeployment.deployment.dto;

import com.simpledeployment.deployment.entity.BankAccount;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BankAccountUpdateRequest {

    @NotBlank
    private String accountId;
    private String holderName;
    @NotNull
    private BankAccount.AccountType accountType;
    @NotBlank
    private String branchName;
    @NotBlank
    private String ifscCode;
    @NotNull
    @DecimalMin(value = "0.0", inclusive = true)
    private BigDecimal totalBalance;
}
