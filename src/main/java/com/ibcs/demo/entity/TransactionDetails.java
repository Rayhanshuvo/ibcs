package com.ibcs.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "transaction_details")
public class TransactionDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "transaction_id")
    private String transactionId;
    @Column(name = "creditor_account")
    private String creditor_account;
    @Column(name = "debit_account")
    private String debit_account;
    @Column(name = "amount")
    private Double amount;
    @Column(name = "transaction_type")
    private String transactionType;

}
