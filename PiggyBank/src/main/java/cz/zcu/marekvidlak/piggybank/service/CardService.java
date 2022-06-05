package cz.zcu.marekvidlak.piggybank.service;

import cz.zcu.marekvidlak.piggybank.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The CardService class is a service class that uses the CardRepository class to perform CRUD operations on the Card
 * class.
 */
@Service
public class CardService {
    private final CardRepository cardRepository;

    @Autowired
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }
}
