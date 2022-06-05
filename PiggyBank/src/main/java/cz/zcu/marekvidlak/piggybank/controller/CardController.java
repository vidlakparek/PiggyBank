package cz.zcu.marekvidlak.piggybank.controller;

import cz.zcu.marekvidlak.piggybank.service.CardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The CardController class is a Spring MVC controller that handles HTTP requests for the Card domain object
 */
@Slf4j
@Controller
@RequestMapping("/api/v1/card")
public class CardController {
    private final CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }
}
