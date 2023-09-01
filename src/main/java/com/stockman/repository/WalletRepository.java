package com.stockman.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockman.model.Transaction;

public interface WalletRepository extends JpaRepository<Transaction, Integer>{

}
