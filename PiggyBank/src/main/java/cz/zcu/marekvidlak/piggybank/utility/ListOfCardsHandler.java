package cz.zcu.marekvidlak.piggybank.utility;

import cz.zcu.marekvidlak.piggybank.entity.Account;
import cz.zcu.marekvidlak.piggybank.entity.CensoredCard;
import cz.zcu.marekvidlak.piggybank.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * If the user has a card, return a list of censored cards.
 */
public class ListOfCardsHandler {
    public static boolean canHandle(User user) {
        for (Account account : user.getAccounts()) {
            if (account.getCard() != null) {
                return true;
            }
        }
        return false;
    }

    public static List<CensoredCard> handle(User user) {
        List<CensoredCard> list = new ArrayList<>();
        for (Account account : user.getAccounts()) {
            if (account.getCard() != null) {
                list.add(account.getCard().getCensored());
            }
        }
        return list;
    }
}
