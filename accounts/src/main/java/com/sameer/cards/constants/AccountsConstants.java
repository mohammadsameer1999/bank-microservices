package com.sameer.cards.constants;

public final class AccountsConstants {

    // Private constructor to prevent instantiation
    private AccountsConstants() {
        // restrict instantiation
    }

    // ================= ACCOUNT DEFAULTS =================

    // Account Types
    public static final String SAVINGS = "Savings";

    // Default Address
    public static final String ADDRESS = "Hauz Khas, New Delhi, Delhi 110016";


    // ================= SUCCESS RESPONSES =================

    public static final String STATUS_201 = "201";
    public static final String MESSAGE_201 = "Account created successfully";

    public static final String STATUS_200 = "200";
    public static final String MESSAGE_200 = "Request processed successfully";


    // ================= FAILED OPERATIONS (417) =================

    public static final String STATUS_417 = "417";

    public static final String MESSAGE_417_UPDATE =
            "Update operation failed. Please try again or contact Dev team";

    public static final String MESSAGE_417_DELETE =
            "Delete operation failed. Please try again or contact Dev team";


    // ================= GENERIC ERROR =================

    public static final String STATUS_500 = "500";

    public static final String MESSAGE_500 =
            "An error occurred. Please try again or contact Dev team";
}
