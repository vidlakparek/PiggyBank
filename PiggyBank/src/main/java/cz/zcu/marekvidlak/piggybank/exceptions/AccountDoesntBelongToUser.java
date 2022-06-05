package cz.zcu.marekvidlak.piggybank.exceptions;

/**
 * AccountDoesntBelongToUser is a RuntimeException that is thrown when an account does not belong to a user.
 */
public class AccountDoesntBelongToUser extends RuntimeException {
    public AccountDoesntBelongToUser() {
        super("Account does not belong to this user!");
    }


}
