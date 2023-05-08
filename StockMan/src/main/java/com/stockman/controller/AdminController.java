package com.stockman.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockman.exception.CustomerException;
import com.stockman.exception.ResourceNotFoundException;
import com.stockman.exception.StockException;
import com.stockman.model.Customer;
import com.stockman.model.Stock;
import com.stockman.model.StockReport;
import com.stockman.model.Transaction;
import com.stockman.model.TransactionType;
import com.stockman.service.AdminService;
import com.stockman.service.CustomerService;
import com.stockman.service.TransactionService;

@RestController
@RequestMapping("/stockman")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
    private TransactionService transactionService;

	
	@PostMapping("/stocks")
	public ResponseEntity<Stock> saveStock(@RequestBody Stock stock) throws StockException {
		
		Stock savedStock= adminService.addStock(stock);
		
		
		return new ResponseEntity<Stock>(savedStock,HttpStatus.CREATED);
	}
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomers() throws CustomerException {
		
		List<Customer> customers= customerService.getAllCustomers();
		
		
		return new ResponseEntity<>(customers,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/allStocks")
	public ResponseEntity<List<Stock>> getAllStock() throws StockException {
		
		List<Stock> stocks= adminService.getAllStocks();
		
		
		return new ResponseEntity<>(stocks,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{name}/report")
    public ResponseEntity<StockReport> getStockReport(@PathVariable String name)throws ResourceNotFoundException, StockException{
        Stock stock = adminService.findStockByName(name);
                
        
        Integer stockId = stock.getStockId();
        
        Integer sold = transactionService.getTotalSoldQuantityByStockId(stockId);
                
        Integer remaining = stock.getTotalQuantity() - sold.intValue();

        return new ResponseEntity<>(new StockReport(stock.getStockName(), stock.getTotalQuantity(), sold, remaining),HttpStatus.ACCEPTED);
    }
	
	
	
	
	@DeleteMapping("/customers/{customerId}")
	public ResponseEntity<Customer> deleteCustomerAccount(@PathVariable Integer customerId) throws CustomerException, ResourceNotFoundException {
	    Customer customer = customerService.findCustomerById(customerId);
	    
	    // Credit the total amount of all stocks to the customer's wallet
	    
	    double totalValue = 0.0;
	    List<Transaction> transactions = transactionService.findByCustomer(customer);
	    for (Transaction transaction : transactions) {
	        if (transaction.getTransactionType() == TransactionType.BUY) {
	            totalValue += transaction.getTransactionPrice();
	        } else if (transaction.getTransactionType() == TransactionType.SOLD) {
	            totalValue -= transaction.getTransactionPrice();
	        }
	    }
	    customer.getWallet().setBalance(customer.getWallet().getBalance() + totalValue);
	    
	    // Set account inactive
	    customer.setActive(false);
	    
	    Customer customer2=customerService.save(customer);
	    
	    return new ResponseEntity<>(customer2,HttpStatus.ACCEPTED);
	}
	
}













