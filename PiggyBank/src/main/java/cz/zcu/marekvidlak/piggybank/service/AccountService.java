package cz.zcu.marekvidlak.piggybank.service;

import cz.zcu.marekvidlak.piggybank.entity.Account;
import cz.zcu.marekvidlak.piggybank.repository.AccountRepository;
import cz.zcu.marekvidlak.piggybank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * The AccountService class is a Spring service class that uses the AccountRepository class to perform CRUD operations on
 * the account table in the database
 */
@Service
public class AccountService {
    private final UserRepository userRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(UserRepository userRepository, AccountRepository accountRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
    }


    public Account getAccount(Long accountNumber) {
        return accountRepository.findById(accountNumber).orElseThrow();
    }



}
