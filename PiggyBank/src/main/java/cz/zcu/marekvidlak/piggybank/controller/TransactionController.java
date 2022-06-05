package cz.zcu.marekvidlak.piggybank.controller;

import cz.zcu.marekvidlak.piggybank.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * It's a controller that handles requests to the /api/v1/transaction endpoint
 */
@Slf4j
@Controller
@RequestMapping("/api/v1/transaction")
public class TransactionController {
    private final TransactionService transactionService;


    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }
}
