package com.sameer.cards.service.impl;

import com.sameer.cards.constants.AccountsConstants;
import com.sameer.cards.dto.AccountsDto;
import com.sameer.cards.dto.CustomerDto;
import com.sameer.cards.entity.Accounts;
import com.sameer.cards.entity.Customer;
import com.sameer.cards.exception.CustomerAlreadyExitsException;
import com.sameer.cards.exception.ResourceNotFoundException;
import com.sameer.cards.mapper.AccountsMapper;
import com.sameer.cards.mapper.CustomerMapper;
import com.sameer.cards.repository.AccountsRepository;
import com.sameer.cards.repository.CustomerRepository;
import com.sameer.cards.service.IAccountsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class AccountsServiceImpl implements IAccountsService {
    @Autowired
    private final AccountsRepository accountsRepository;
    private final CustomerRepository customerRepository;

    /**
     *
     * @param customerDto - Customer Dto Object
     */
    @Override
    public void createAccount(CustomerDto customerDto) {
        // TODO document why this method is empty

        Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());
        Optional<Customer> customer1 = customerRepository.findByMobileNumber(customerDto.getMobileNumber());
        if (customer1.isPresent()) {
            throw new CustomerAlreadyExitsException("Customer already registered with given mobileNumber "
                    + customerDto.getMobileNumber() );

        }

       Customer savedCustomer =  customerRepository.save(customer);
       accountsRepository.save(createNewAccount(savedCustomer));
    }

    /**
     *
     * @param customer - customer object
     * @return the new accounts details
     */
    private Accounts createNewAccount(Customer customer) {
        Accounts newAccounts = new Accounts();
        newAccounts.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);
        newAccounts.setAccountNumber(randomAccNumber);
        newAccounts.setAccountType(AccountsConstants.SAVINGS);
        newAccounts.setBranchAddress(AccountsConstants.ADDRESS);

        return newAccounts;
    }

    /**
     *
     * @param mobileNumber - input mobile Number
     * @return Accounts Details based on a given mobileNumber
     */
    @Override
    public CustomerDto fetchAccount(String mobileNumber) {
        Customer  customer = customerRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(
                        () ->   new ResourceNotFoundException("customer", "mobileNumber",mobileNumber)
                );

        Accounts  accounts = accountsRepository.findByCustomerId(customer.getCustomerId())
                .orElseThrow(
                        () ->   new ResourceNotFoundException("Accounts", "customerId",customer.getCustomerId().toString())
                );

       CustomerDto customerDto =  CustomerMapper.mapToCustomerDto(customer, new CustomerDto());
       customerDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts,new AccountsDto()));

        return customerDto;
    }
    /**
     *
     * @param customerDto - Customer Dto Object
     * @return boolean indicating if the update account details is successfully or not
     */
    @Override
    public boolean updateAccount(CustomerDto customerDto) {
        boolean isUpdated = false;
        AccountsDto accountsDto = customerDto.getAccountsDto();
        if (accountsDto != null) {
            Accounts accounts = accountsRepository.findById(accountsDto.getAccountNumber()).orElseThrow(
                    () -> new ResourceNotFoundException("Accounts", "accountNumber",accountsDto.getAccountNumber().toString())
            );

            AccountsMapper.mapToAccounts(accountsDto,accounts);
            accountsRepository.save(accounts);
            Long customerId = accounts.getCustomerId();
            Customer customer = customerRepository.findById(customerId).orElseThrow(
                    () -> new ResourceNotFoundException("Customer", "customerId", customerId.toString())
            );

            CustomerMapper.mapToCustomer(customerDto,customer);
            customerRepository.save(customer);
            isUpdated = true;
        }
        return isUpdated;
    }

    @Override
    public boolean deleteAccount(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(
                        () -> new  ResourceNotFoundException("Customer",  "mobileNumber", mobileNumber)
                );
        customerRepository.deleteByCustomerId(customer.getCustomerId());
        customerRepository.deleteById(customer.getCustomerId());
        return true;
    }
}
