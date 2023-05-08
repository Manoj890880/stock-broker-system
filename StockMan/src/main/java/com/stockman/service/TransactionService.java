package com.stockman.service;

import java.util.List;

import javax.transaction.TransactionalException;

import com.stockman.exception.CustomerException;
import com.stockman.exception.ResourceNotFoundException;
import com.stockman.model.Customer;
import com.stockman.model.Transaction;

public interface TransactionService {
	
	public Integer getTotalSoldQuantityByStockId(Integer stockId)throws ResourceNotFoundException;

	public List<Transaction> findByCustomer(Customer customer)
	throws CustomerException,ResourceNotFoundException;

	public void deleteAll(List<Transaction> transactions)throws TransactionalException;

}
