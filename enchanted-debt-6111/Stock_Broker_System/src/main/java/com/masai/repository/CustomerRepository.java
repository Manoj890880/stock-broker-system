package com.masai.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Customer save(Customer customer);

    // READ operations
    List<Customer> findAll();
    Optional<Customer> findById(Integer id);
    List<Customer> findByCustomerName(String name);

    // UPDATE operation
    Customer saveAndFlush(Customer customer);

    // DELETE operations
    void delete(Customer customer);
    void deleteById(Integer id);
    void deleteAll();
}

