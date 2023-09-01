package com.stockman.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stockman.exception.CustomerException;
import com.stockman.exception.ResourceNotFoundException;
import com.stockman.exception.StockException;
import com.stockman.model.Customer;
import com.stockman.model.Stock;
import com.stockman.model.Transaction;
import com.stockman.model.Wallet;
import com.stockman.service.AdminService;
import com.stockman.service.CustomerService;
import com.stockman.service.TransactionService;
import com.stockman.service.WalletService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService cService;
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private TransactionService transactionService;
	
	@Autowired
	private WalletService walletService;
	
	
	@PostMapping("/customers")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) throws CustomerException {
		
		
		Wallet wallet=new Wallet();
		wallet.setBalance(0.0);
		wallet.setCustomer(customer);
		Customer savedCustomer= cService.createCustomer(customer);
		
		return new ResponseEntity<Customer>(savedCustomer,HttpStatus.CREATED);
	}
	
	@PutMapping("/customers")
	public  ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer,@RequestParam String key) throws CustomerException {
		
		
		Customer updatedCustomer= cService.updateCustomer(customer, key);
				
		return new ResponseEntity<Customer>(updatedCustomer,HttpStatus.OK);
		
	}
	
	@GetMapping("/viewAllStocks")
	
	public ResponseEntity<List<Stock>> viewAllStocks(@RequestParam String key) throws StockException, CustomerException {
		
		
		
		
		List<Stock> stocks= cService.getAllStocks(key);
		
		
		return new ResponseEntity<>(stocks,HttpStatus.ACCEPTED);
	}
	
	
	@PostMapping("/customers/{customerId}/stocks/buy")
    public ResponseEntity<Transaction> buyStockByName(
            @PathVariable int customerId, 
            @RequestParam String stockName,
            @RequestParam Integer shares) throws CustomerException, StockException, ResourceNotFoundException {
        
        
            Transaction transaction = cService.buyStockByName(customerId, stockName, shares);
            
            return new ResponseEntity<>(transaction,HttpStatus.ACCEPTED);
        
    }
	
	
	@PostMapping("/sellStockByName")
    public ResponseEntity<Transaction> sellStockByName(@RequestParam Integer customerId, @RequestParam String stockName, @RequestParam Integer shares) throws CustomerException, StockException, ResourceNotFoundException {
        
        Transaction transaction = cService.sellStockByName(customerId, stockName, shares);
            
        
        return new ResponseEntity<>(transaction,HttpStatus.ACCEPTED);
    }
	
	
	@GetMapping("/customers/{customerId}/transactions")
	public ResponseEntity<List<Transaction>> getCustomerTransactions(@PathVariable Integer customerId) throws CustomerException, ResourceNotFoundException {
	    Customer customer = cService.findCustomerById(customerId);
	        
	    List<Transaction> transactions= transactionService.findByCustomer(customer);
	    
	    
	    return new ResponseEntity<>(transactions,HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value = "/addFunds", method = RequestMethod.POST)
	public ResponseEntity<Customer> addFunds(@RequestParam Integer customerId, @RequestParam double amount) throws CustomerException, ResourceNotFoundException {
		Customer customer = cService.findCustomerById(customerId);
	    if (customer == null) {
	        throw new ResourceNotFoundException("Customer not found with id: " + customerId);
	    }
	    if (amount <= 0) {
	        throw new IllegalArgumentException("Amount must be greater than 0");
	    }
	    Double prevBal = customer.getWallet().getBalance();
	    customer.getWallet().setBalance(prevBal + amount);
	    Customer updatedCustomer = cService.save(customer);
	    return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/withdrawFunds", method = RequestMethod.POST)
	public Customer withdrawFunds(@RequestParam Integer customerId, @RequestParam double amount) throws CustomerException, ResourceNotFoundException {
	    Customer customer = cService.findCustomerById(customerId);
	    if (customer.getWallet().getBalance() < amount) {
	        throw new ResourceNotFoundException("Customer has insufficient balance to withdraw the given amount.");
	    }
	    customer.getWallet().setBalance(customer.getWallet().getBalance() - amount);
	    
	    return cService.save(customer);
	}
	
	@RequestMapping(value = "/deleteAccount", method = RequestMethod.DELETE)
	public void deleteAccount(@RequestParam Integer customerId) throws CustomerException, ResourceNotFoundException {
		Customer customer = cService.findCustomerById(customerId);
		
		if (customer.getWallet().getBalance()>0) {
			throw new ResourceNotFoundException("Before delete your account please withdraw money fast");
		}
		
	    // Remove all transactions related to this customer
	    List<Transaction> transactions = transactionService.findByCustomer(customer);
	    transactionService.deleteAll(transactions);

	    // Remove the customer's wallet
	    Wallet wallet = customer.getWallet();
	    customer.setWallet(null);
	    
	    walletService.delete(wallet);

	    // Delete the customer
	    cService.delete(customer);
	}
}
