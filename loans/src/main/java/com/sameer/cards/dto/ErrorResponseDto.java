package com.sameer.cards.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Schema(
        name = "ErrorResponse",
        description = "Standard error response returned when API fails"
)
public class ErrorResponseDto {

    @Schema(
            description = "API endpoint path where error occurred",
            example = "/api/create"
    )
    private String apiPath;

    @Schema(
            description = "HTTP status code",
            example = "BAD_REQUEST"
    )
    private HttpStatus errorCode;

    @Schema(
            description = "Detailed error message",
            example = "Mobile number is required"
    )
    private String errorMessage;

    @Schema(
            description = "Date when error happened",
            example = "2026-02-17"
    )
    private LocalDate errorTime;
}
