package com.sameer.cards.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(
        name = "Loan",
        description = "Loan details associated with customer"
)
public class LoansDto {

    @Schema(
            description = "Loan number",
            example = "9876543210",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotNull(message = "Loan number cannot be null")
    private String loanNumber;

    @Schema(
            description = "Customer mobile number",
            example = "9876543210",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotNull(message = "Mobile number cannot be null")
    private String mobileNumber;

    @Schema(
            description = "Type of loan",
            example = "Home Loan",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "Loan type cannot be empty")
    private String loanType;

    @Schema(
            description = "Total loan amount",
            example = "500000"
    )
    private int totalLoan;

    @Schema(
            description = "Amount paid",
            example = "100000"
    )
    private int amountPaid;

    @Schema(
            description = "Outstanding amount",
            example = "400000"
    )
    private int outstandingAmount;
}
