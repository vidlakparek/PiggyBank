package cz.zcu.marekvidlak.piggybank.controller;

import cz.zcu.marekvidlak.piggybank.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * It's a controller that exposes a REST endpoint that calls a service that calls a repository
 */
@Slf4j
@Controller
@RequestMapping("/api/v1/account")
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


}
