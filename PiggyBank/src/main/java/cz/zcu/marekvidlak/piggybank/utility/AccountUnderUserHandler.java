package cz.zcu.marekvidlak.piggybank.utility;

import cz.zcu.marekvidlak.piggybank.entity.Account;
import cz.zcu.marekvidlak.piggybank.entity.User;

import java.util.Set;

/**
 * This class contains a method that checks if a user has a given account.
 */
public class AccountUnderUserHandler {

    public static boolean canHandle(User user, Account account) {
        Set<Account> accounts = user.getAccounts();
        return accounts.contains(account);
    }


}
