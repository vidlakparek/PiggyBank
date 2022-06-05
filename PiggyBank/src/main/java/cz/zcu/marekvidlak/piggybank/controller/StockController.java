package cz.zcu.marekvidlak.piggybank.controller;

import cz.zcu.marekvidlak.piggybank.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The StockController class is a Spring MVC controller that exposes a REST API for the StockService class
 */

@Slf4j
@Controller
@RequestMapping("/api/v1/stock")
public class StockController {
    private final StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }
}
