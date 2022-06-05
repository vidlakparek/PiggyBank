package cz.zcu.marekvidlak.piggybank.configuration;

import cz.zcu.marekvidlak.piggybank.entity.Account;
import cz.zcu.marekvidlak.piggybank.entity.User;
import cz.zcu.marekvidlak.piggybank.service.AccountService;
import cz.zcu.marekvidlak.piggybank.utility.AccountUnderUserHandler;
import cz.zcu.marekvidlak.piggybank.utility.ListOfCardsHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;

/**
 * It's a Spring MVC controller that handles requests to the root URL and the login URL
 */
@Controller
@RequestMapping("/")
public class TemplateController {
    private final AccountService accountService;

    @Autowired
    public TemplateController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("login")
    public String getLoginView() {
        return "login";
    }

    @GetMapping("login-error")
    public String getLoginErrorView(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

    @GetMapping
    public String getIndex(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("user", user);
        model.addAttribute("accounts", user.getAccounts());
        model.addAttribute(
                "cards",
                ListOfCardsHandler.canHandle(user) ? ListOfCardsHandler.handle(user) : Collections.emptyList());
        return "index";
    }

    @GetMapping("account/{accountNumber}")
    public String getAccount(Model model, @PathVariable Long accountNumber, @AuthenticationPrincipal User user){
        Account acc = accountService.getAccount(accountNumber);
        model.addAttribute("user", user);
        if(AccountUnderUserHandler.canHandle(user,acc)){
            model.addAttribute("selected_account",acc);
            model.addAttribute("accounts",user.getAccounts());
        }
        return "account";
    }

}
