package com.sameer.cards.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(
        name = "Customer",
        description = "Customer information used for account creation and update"
)
public class CustomerDto {

    @Schema(
            description = "Customer full name",
            example = "Sameer Khan",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "Name cannot be empty")
    private String name;

    @Schema(
            description = "Customer email address",
            example = "sameer@gmail.com",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @Email(message = "Invalid email format")
    @NotBlank(message = "Email cannot be empty")
    private String email;

    @Schema(
            description = "Customer mobile number (10 digits)",
            example = "9876543210",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "Mobile number cannot be empty")
    @Pattern(
            regexp = "^[0-9]{10}$",
            message = "Mobile number must be 10 digits"
    )
    private String mobileNumber;

    @Schema(
            description = "Account details associated with customer"
    )
    @Valid
    private AccountsDto accountsDto;
}
