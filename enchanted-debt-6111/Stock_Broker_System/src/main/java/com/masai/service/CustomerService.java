package com.masai.service;

import java.util.List;
import java.util.Optional;
import com.masai.model.Customer;

public interface CustomerService {

    // CREATE operation
    public Customer addCustomer(Customer customer);

    // READ operations
    public List<Customer> getAllCustomers();
    public Optional<Customer> getCustomerById(Integer id);
    public List<Customer> getCustomersByName(String name);

    // UPDATE operation
    public Customer updateCustomer(Customer customer);

    // DELETE operations
    public void deleteCustomer(Customer customer);
    public void deleteCustomerById(Integer id);
    public void deleteAllCustomers();
}

