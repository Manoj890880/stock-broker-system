package com.masai.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.masai.model.Customer;
import com.masai.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // CREATE operation
    @PostMapping("/add")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        Customer savedCustomer = customerService.addCustomer(customer);
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }

    // READ operations
    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Integer id) {
        Optional<Customer> customer = customerService.getCustomerById(id);
        return customer.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Customer>> getCustomersByName(@RequestParam("name") String name) {
        List<Customer> customers = customerService.getCustomersByName(name);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    // UPDATE operation
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") Integer id, @RequestBody Customer customer) {
        Optional<Customer> optionalExistingCustomer = customerService.getCustomerById(id);
        if (optionalExistingCustomer.isPresent()) {
            Customer existingCustomer = optionalExistingCustomer.get();
            existingCustomer.setCustomer_Name(customer.getCustomer_Name());
            existingCustomer.setCustomer_Password(customer.getCustomer_Password());
            existingCustomer.setCustomer_Contact(customer.getCustomer_Contact());
            existingCustomer.setCustomer_Email(customer.getCustomer_Email());
            existingCustomer.setWallet(customer.getWallet());
            return new ResponseEntity<>(customerService.updateCustomer(existingCustomer), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // DELETE operations
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomerById(@PathVariable("id") Integer id) {
        Optional<Customer> optionalCustomer = customerService.getCustomerById(id);
        if (optionalCustomer.isPresent()) {
            customerService.deleteCustomerById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/all")
    public ResponseEntity<Void> deleteAllCustomers() {
        customerService.deleteAllCustomers();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
