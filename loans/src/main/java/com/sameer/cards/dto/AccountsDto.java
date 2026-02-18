package com.sameer.cards.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(
        name = "Account",
        description = "Account details associated with a customer"
)
public class AccountsDto {

    @Schema(
            description = "Unique account number",
            example = "1234567890",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotNull(message = "Account number cannot be null")
    private Long accountNumber;

    @Schema(
            description = "Type of account (Savings/Current)",
            example = "Savings",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "Account type cannot be empty")
    private String accountType;

    @Schema(
            description = "Bank branch address",
            example = "Mumbai Main Branch",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "Branch address cannot be empty")
    private String branchAddress;
}
