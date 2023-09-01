package com.stockman.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.TransactionalException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockman.exception.CustomerException;
import com.stockman.exception.ResourceNotFoundException;
import com.stockman.model.Customer;
import com.stockman.model.Transaction;
import com.stockman.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService{
	@Autowired
	private TransactionRepository transactionRepository;
	
	
	@Override
	public Integer getTotalSoldQuantityByStockId(Integer stockId) throws ResourceNotFoundException {
		Integer numInteger=transactionRepository.getTotalSoldQuantityByStockId(stockId);
		if (numInteger==null) {
			return 0;
		}
		return transactionRepository.getTotalSoldQuantityByStockId(stockId).intValue();
	}


	@Override
	public List<Transaction> findByCustomer(Customer customer) throws CustomerException, ResourceNotFoundException {
		List<Transaction> transactions=transactionRepository.findByCustomer(customer);
		if (transactions.size()==0) {
			throw new ResourceNotFoundException("No transactions found");
		}
		return transactions;
	}


	@Override
	public void deleteAll(List<Transaction> transactions) throws TransactionalException {
		
		transactionRepository.deleteAll(transactions);
		
	}

}
