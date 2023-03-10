package com.example.one_hundred_and_twenty_eighth.services;

import com.example.one_hundred_and_twenty_eighth.models.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Customer getById(Long id);
    void save(Customer customer);
    void delete(Long id);
    List<Customer> getAll();
}
