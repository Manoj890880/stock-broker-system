package com.stockman.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "transactions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Integer transactionId;

    @Column(name = "transaction_type")
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
    
    @Column(name = "transaction_date")
    private LocalDate transactionDate;
    
    @Column(name = "transaction_price")
    private double transactionPrice;

    @Column(name = "quantity")
    private int quantity;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;
    
    @ManyToOne
    @JoinColumn(name = "stock_id")
    private Stock stock;

    
    @ManyToOne
    @JoinColumn(name = "mutual_fund_id")
    private MutualFund mutualFund;

    
    @ManyToOne
    @JoinColumn(name = "loan_id")
    private LoanAgainstShare loanAgainstShare;
    

    

    // getters and setters
}
