package com.stockman.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.stockman.model.Customer;
import com.stockman.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>{
	
	@Query("SELECT SUM(t.quantity) FROM Transaction t WHERE t.stock.stockId = ?1 AND t.transactionType = 'SOLD'")
    public Integer getTotalSoldQuantityByStockId(int stockId);
	
	
	public List<Transaction> findByCustomer(Customer customer);
}
