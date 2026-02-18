package com.sameer.cards.service;

import com.sameer.cards.dto.CustomerDto;

public interface IAccountsService {
    /**
     *
     * @param customerDto - Customer Dto Object
     */
    void createAccount(CustomerDto customerDto);

    /**
     *
     * @param mobileNumber - input mobile Number
     * @return Accounts Details based on a given mobileNumber
     */
    CustomerDto fetchAccount(String mobileNumber);

    /**
     *
     * @param customerDto - Customer Dto Object
     * @return boolean indicating if the update account details is successfully or not
     */
    boolean updateAccount(CustomerDto customerDto);

    /**
     *
     * @param mobileNumber - ID of the customer
     * @return boolean indicating whether the account details were successfully deleted or not
     */
    boolean deleteAccount(String mobileNumber);

}
