package cz.zcu.marekvidlak.piggybank.exceptions;

/**
 * It's a runtime exception that is thrown when a card is not linked to an account
 */
public class CardToThisAccountDoesntExistException extends RuntimeException {
    public CardToThisAccountDoesntExistException() {
        super("This account does not have any card linked to itself!");
    }
}
