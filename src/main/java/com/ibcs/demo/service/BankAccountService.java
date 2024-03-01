package com.ibcs.demo.service;

import com.ibcs.demo.entity.BankAccount;
import com.ibcs.demo.entity.Employee;
import com.ibcs.demo.repository.BankAccountRepository;
import com.ibcs.demo.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankAccountService {
    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Transactional
    public BankAccount createBankAccount(BankAccount bankAccount) {
        return bankAccountRepository.save(bankAccount);
    }

    public List<BankAccount> getAllBankAccounts() {
        return bankAccountRepository.findAll();
    }
}
