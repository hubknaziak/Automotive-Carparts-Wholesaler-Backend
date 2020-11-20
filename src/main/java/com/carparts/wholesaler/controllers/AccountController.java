package com.carparts.wholesaler.controllers;

import com.carparts.wholesaler.dtos.AccountDto;
import com.carparts.wholesaler.models.Account;
import com.carparts.wholesaler.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @CrossOrigin
    @PostMapping(value = "/addAccount")
    public Account addAccount(@RequestBody AccountDto accountDto){
        return accountService.addAccount(accountDto);
    }

    @CrossOrigin
    @GetMapping("getAccountByEmail")
    public int getAccountByEmail(@RequestParam String email){
        return accountService.getAccountByEmail(email);
    }

    @CrossOrigin
    @GetMapping("getAccountByClientId/{idClient}")
    public String getEmailByClientId(@PathVariable int idClient){
        return accountService.getEmailByClientId(idClient);
    }

    @CrossOrigin
    @PutMapping("disableAccount/{idAccount}")
    public Account disableAccount(@PathVariable int idAccount){
        return accountService.disableAccount(idAccount);
    }

    @CrossOrigin
    @PutMapping("updateAccount/{idAccount}")
    public Account updateAccount(@RequestBody AccountDto accountDto, @PathVariable int idAccount){return accountService.updateAccount(accountDto, idAccount);}

    @CrossOrigin
    @PostMapping("/login")
    public void login(@RequestBody AccountDto accountDto){

    }

    @CrossOrigin
    @PostMapping("/logout")
    public void logout(){

    }
}
