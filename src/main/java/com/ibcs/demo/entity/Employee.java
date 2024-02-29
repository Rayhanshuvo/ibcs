package com.ibcs.demo.entity;


import jakarta.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String employeeId;
    private String name;
    private String address;
    private String mobile;
    @OneToOne
    private Grade grade;
    @OneToOne
    private BankAccount bankAccountNumber;

    public Employee(Long id, String employeeId, String name, String address, String mobile, Grade grade, BankAccount bankAccountNumber) {
        this.id = id;
        this.employeeId = employeeId;
        this.name = name;
        this.address = address;
        this.mobile = mobile;
        this.grade = grade;
        this.bankAccountNumber = bankAccountNumber;
    }

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public BankAccount getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(BankAccount bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }
}
