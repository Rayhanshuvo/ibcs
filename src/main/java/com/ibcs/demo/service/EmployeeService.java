package com.ibcs.demo.service;

import com.ibcs.demo.dto.EmployeeRequest;
import com.ibcs.demo.entity.BankAccount;
import com.ibcs.demo.entity.Employee;
import com.ibcs.demo.entity.Grade;
import com.ibcs.demo.repository.BankAccountRepository;
import com.ibcs.demo.repository.EmployeeRepository;
import com.ibcs.demo.repository.GradeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired
    private GradeRepository gradeRepository;
    
    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Transactional
    public Employee createEmployee(EmployeeRequest employeeRequest) {
        Employee employee = new Employee();
        Grade grade = gradeRepository.findById(employeeRequest.getGradeId())
                .orElseThrow(() -> new RuntimeException("Grade not found with id: " + employeeRequest.getGradeId()));

        BankAccount bankAccount = bankAccountRepository.findById(employeeRequest.getBankAccountId())
                .orElseThrow(() -> new RuntimeException("BankAccount not found with id: " + employeeRequest.getBankAccountId()));
        employee.setGrade(grade);
        employee.setBankAccountNumber(bankAccount);
        return employeeRepository.save(employee);
    }

}
