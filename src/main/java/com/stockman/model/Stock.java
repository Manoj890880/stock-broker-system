package com.stockman.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "stocks")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stock_id")
    private Integer stockId;

    @Column(name = "stock_name")
    private String stockName;

    @Column(name = "current_price")
    private double currentPrice;

    @Column(name = "total_quantity")
    private Integer totalQuantity;

    @Column(name = "available_quantity")
    private Integer availableQuantity;

    @Column(name = "is_active")
    private boolean isActive = true;
    
    @OneToMany(mappedBy = "stock", cascade = CascadeType.ALL)
    private List<Transaction> transactions = new ArrayList<>();
    
    @ManyToMany(mappedBy = "stocks")
    private List<Customer> customers = new ArrayList<>();

	

    // getters and setters
}

