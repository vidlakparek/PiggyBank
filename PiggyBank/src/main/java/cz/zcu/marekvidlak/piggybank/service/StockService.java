package cz.zcu.marekvidlak.piggybank.service;

import cz.zcu.marekvidlak.piggybank.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The StockService class is a Spring service class that uses the StockRepository class to perform CRUD operations on the
 * stock table
 */
@Service
public class StockService {
    private final StockRepository staockRepository;

    @Autowired
    public StockService(StockRepository staockRepository) {
        this.staockRepository = staockRepository;
    }
}
