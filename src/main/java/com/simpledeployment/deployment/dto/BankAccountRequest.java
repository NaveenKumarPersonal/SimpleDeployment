package com.simpledeployment.deployment.dto;

import com.simpledeployment.deployment.entity.BankAccount;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BankAccountRequest {

    @NotBlank
    private String holderName;

    @NotNull
    private BankAccount.AccountType accountType;

    @NotBlank
    @Pattern(regexp = "\\d{9,18}", message = "Account number must be 9-18 digits")
    private String accountNumber;

    @NotBlank
    @Pattern(regexp = "^[A-Z]{4}0[A-Z0-9]{6}$", message = "Invalid IFSC code")
    private String ifscCode;

    @NotBlank
    private String branchName;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = true)
    private BigDecimal totalBalance;
}
