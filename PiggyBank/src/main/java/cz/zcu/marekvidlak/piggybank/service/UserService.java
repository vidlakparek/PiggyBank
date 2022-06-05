package cz.zcu.marekvidlak.piggybank.service;

import cz.zcu.marekvidlak.piggybank.entity.Account;
import cz.zcu.marekvidlak.piggybank.entity.User;
import cz.zcu.marekvidlak.piggybank.repository.AccountRepository;
import cz.zcu.marekvidlak.piggybank.repository.UserRepository;
import cz.zcu.marekvidlak.piggybank.security.PasswordConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * The UserService class is a service class that provides methods for creating, updating, and deleting users
 */
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordConfig passwordEncoder;
    private final AccountRepository accountRepository;

    @Autowired
    public UserService(
            UserRepository userRepository, PasswordConfig passwordEncoder, AccountRepository accountRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.accountRepository = accountRepository;
    }


    public Set<Account> getAccounts(User user) {
        return user.getAccounts();
    }


}
