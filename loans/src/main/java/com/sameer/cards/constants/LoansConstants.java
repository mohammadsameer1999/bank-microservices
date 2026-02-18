package com.sameer.cards.constants;

public final class LoansConstants {

    // Private constructor to prevent instantiation
    private LoansConstants() {
        // restrict instantiation
    }

    // ================= LOAN DEFAULTS =================

    // Loan Types
    public static final String HOME_LOAN = "Home Loan";
    public static final String CAR_LOAN = "Car Loan";
    public static final String PERSONAL_LOAN = "Personal Loan";
    public static final int  NEW_LOAN_LIMIT = 1_00_000;


    // Default Branch Address
    public static final String ADDRESS = "Hauz Khas, New Delhi, Delhi 110016";


    // ================= SUCCESS RESPONSES =================

    public static final String STATUS_201 = "201";
    public static final String MESSAGE_201 = "Loan created successfully";

    public static final String STATUS_200 = "200";
    public static final String MESSAGE_200 = "Request processed successfully";


    // ================= FAILED OPERATIONS (417) =================

    public static final String STATUS_417 = "417";

    public static final String MESSAGE_417_UPDATE =
            "Loan update operation failed. Please try again or contact Dev team";

    public static final String MESSAGE_417_DELETE =
            "Loan delete operation failed. Please try again or contact Dev team";


    // ================= GENERIC ERROR =================

    public static final String STATUS_500 = "500";

    public static final String MESSAGE_500 =
            "An error occurred. Please try again or contact Dev team";
}
