package com.stockman.service;

import java.util.List;

import com.stockman.exception.StockException;
import com.stockman.model.Stock;

public interface AdminService {
	public Stock addStock(Stock stock)throws StockException;

	public List<Stock> getAllStocks()throws StockException;

	public Stock findStockByName(String name)throws StockException;

	public List<Stock> findByCustomers_Id(Integer id)throws StockException;
}
