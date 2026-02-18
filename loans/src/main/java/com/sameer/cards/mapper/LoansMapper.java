package com.sameer.cards.mapper;

import com.sameer.cards.dto.LoansDto;
import com.sameer.cards.entity.Loans;

public class LoansMapper {

    // Entity -> DTO
    public static LoansDto mapToLoanDto(Loans loans, LoansDto loanDto) {
        loanDto.setLoanNumber(loans.getLoanNumber());
        loanDto.setMobileNumber(loans.getMobileNumber());
        loanDto.setLoanType(loans.getLoanType());
        loanDto.setTotalLoan(loans.getTotalLoan());
        loanDto.setAmountPaid(loans.getAmountPaid());
        loanDto.setOutstandingAmount(loans.getOutstandingAmount());

        return loanDto;
    }

    // DTO -> Entity
    public static Loans mapToLoans(LoansDto loanDto, Loans loans) {
        loans.setLoanNumber(loanDto.getLoanNumber());
        loans.setMobileNumber(loanDto.getMobileNumber());
        loans.setLoanType(loanDto.getLoanType());
        loans.setTotalLoan(loanDto.getTotalLoan());
        loans.setAmountPaid(loanDto.getAmountPaid());
        loans.setOutstandingAmount(loanDto.getOutstandingAmount());

        return loans;
    }
}
