package com.ibcs.demo.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Pattern(regexp = "\\d{4}", message = "Employee ID should be 4 digits")
    private String employeeId;
    private String name;
    private String address;
    private String mobile;
    @OneToOne
    private Grade grade;
    @OneToOne
    private BankAccount bankAccountNumber;

}
