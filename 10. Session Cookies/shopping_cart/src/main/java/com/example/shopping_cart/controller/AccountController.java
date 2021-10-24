package com.example.shopping_cart.controller;

import com.example.shopping_cart.model.Account;
import com.example.shopping_cart.service.AccountService;
import com.example.shopping_cart.service.ParamService;
import com.example.shopping_cart.service.SessionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private ParamService paramService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private SessionService sessionService;

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("account", new Account());
        return "account/register-form";
    }

    @PostMapping("/saveOrUpdate")
    public String saveOrUpdate(@Validated @ModelAttribute("account") Account account, BindingResult result, Model model) {
        if(result.hasFieldErrors()) {
            return "account/register-form";
        }
        
        if (accountService.findAccountByUsername(account.getUsername()) == null) {
            accountService.saveOrUpdate(account);
            model.addAttribute("message", "Dang Ky Thanh Cong!");
        } else {
            model.addAttribute("message", "Cap Nhat Thanh Cong!");
            accountService.saveOrUpdate(account);
        }
        return "account/register-form";
    }

    @GetMapping("/edit/{username}")
    public String editAccount(@PathVariable("username") String username, Model model) {
        Account account = accountService.findAccountByUsername(username);
        model.addAttribute("account", account);
        return "account/register-form";
    }

    @GetMapping("/delete/{username}")
    public String deleteAccount(@PathVariable("username") String username) {
        accountService.removeAccountByUsername(username);
        return "redirect:/account/view-form";
    }

    @GetMapping("views")
    public String viewAccounts(Model model) {
        model.addAttribute("accounts", accountService.findAllAccount()); 
        return "account/view-form";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "account/login-form";
    }

    @PostMapping("/login")
    public String login(Model model) {
        String username = paramService.getString("username", "");
        String password = paramService.getString("password", "");
        try {
            Account account = accountService.findAccountByUsername(username);
            if (!account.getPassword().equals(password)) {
                model.addAttribute("message", "Invalid Password. Try again.");
            } else {
                String url = sessionService.get("account-service");
                if (url != null) {
                    return "redirect:" + url;
                } else {
                    model.addAttribute("message", "Login successed!");
                    sessionService.set("username", username);
                }
            }
        } catch(Exception exception) {
            model.addAttribute("message", "Invalid Username. Try again.");
        }
        return "redirect:/product/view-form";
    }

    @GetMapping("/logout")
    public String logout() {
        sessionService.remove("username");
        return "account/login-form";
    }
}
