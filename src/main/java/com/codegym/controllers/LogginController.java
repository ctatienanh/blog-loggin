package com.codegym.controllers;

import com.codegym.Filter.Loggin;
import com.codegym.models.Account;
import com.codegym.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogginController {
    @Autowired
    AccountService accountService;

    @GetMapping("/dangky")
    public ModelAndView Showdk() {
        ModelAndView modelAndView = new ModelAndView("Dangky");
        return modelAndView;
    }

    @PostMapping("/dangky")
    public  ModelAndView dk(Account account){
        ModelAndView modelAndView = new ModelAndView("redirect:/blogs");
        accountService.create(account);
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView logg(@RequestParam String name , @RequestParam String pass){
        for (Account account: accountService.getall()) {
            if (account.getName().equals(name)&&account.getPass().equals(pass)){
                Loggin.account = account;
            }
        }
        ModelAndView modelAndView = new ModelAndView("home");
        return modelAndView;
    }

}
