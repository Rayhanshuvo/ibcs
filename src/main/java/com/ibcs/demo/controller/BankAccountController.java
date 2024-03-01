package com.ibcs.demo.controller;

import com.ibcs.demo.entity.BankAccount;
import com.ibcs.demo.service.BankAccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank-accounts")
public class BankAccountController {
   @Autowired
    private BankAccountService bankAccountService;

    @PostMapping("/create")
    public ResponseEntity<?> createBankAccount(@Valid @RequestBody BankAccount bankAccount, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>("Invalid data provided", HttpStatus.BAD_REQUEST);
        }
        BankAccount newBankAccount = bankAccountService.createBankAccount(bankAccount);
        return new ResponseEntity<>(newBankAccount, HttpStatus.CREATED);
    }
/*
    @GetMapping("/{id}")
    public BankAccount getBankAccountById(@PathVariable Long id) {
        return bankAccountService.getBankAccountById(id);
    }

    @PutMapping("/{id}")
    public BankAccount updateBankAccount(@PathVariable Long id, @RequestBody BankAccount bankAccount) {
        return bankAccountService.updateBankAccount(id, bankAccount);
    }

    @DeleteMapping("/{id}")
    public void deleteBankAccount(@PathVariable Long id) {
        bankAccountService.deleteBankAccount(id);
}*/
}