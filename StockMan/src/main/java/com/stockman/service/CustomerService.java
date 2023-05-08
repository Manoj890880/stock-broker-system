package com.stockman.service;

import java.util.List;

import com.stockman.exception.CustomerException;
import com.stockman.exception.ResourceNotFoundException;
import com.stockman.exception.StockException;
import com.stockman.model.Customer;
import com.stockman.model.Stock;
import com.stockman.model.Transaction;

public interface CustomerService {
	
	
	public Customer createCustomer(Customer customer)throws CustomerException;
	
	public Customer updateCustomer(Customer customer,String key)throws CustomerException;

	public List<Customer> getAllCustomers()throws CustomerException;

	public Customer findCustomerById(Integer id)throws CustomerException;

	public List<Stock> getAllStocks(String key)throws CustomerException;

	public Transaction buyStockByName(Integer customerId, String stockName, Integer shares)
	throws CustomerException,StockException,ResourceNotFoundException;

	public Transaction sellStockByName(Integer customerId, String stockName, Integer shares)
			throws CustomerException,StockException,ResourceNotFoundException;

	public Customer save(Customer customer)throws CustomerException;

	public void delete(Customer customer)throws CustomerException;

	
}





