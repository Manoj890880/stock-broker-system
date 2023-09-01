package com.stockman.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockman.model.Stock;

public interface AdminRepository extends JpaRepository<Stock, Integer>{

	public Stock findByStockName(String stockName);
	
	public List<Stock> findByCustomers_CustomerId(Integer id);

}
