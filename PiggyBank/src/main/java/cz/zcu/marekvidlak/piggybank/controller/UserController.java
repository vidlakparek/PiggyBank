package cz.zcu.marekvidlak.piggybank.controller;

import cz.zcu.marekvidlak.piggybank.entity.Account;
import cz.zcu.marekvidlak.piggybank.entity.User;
import cz.zcu.marekvidlak.piggybank.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

/**
 * It's a controller that exposes a REST endpoint that returns a set of accounts for a given user
 */
@Slf4j
@Controller
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/accounts")
    public Set<Account> getAccounts(@AuthenticationPrincipal User user) {
        return userService.getAccounts(user);
    }


}
