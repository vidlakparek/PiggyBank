package cz.zcu.marekvidlak.piggybank.service;

import cz.zcu.marekvidlak.piggybank.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The TransactionService class is a Spring service that uses the TransactionRepository class to perform CRUD operations on
 * the transaction table.
 */
@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }
}
