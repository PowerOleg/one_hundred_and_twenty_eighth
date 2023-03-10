package com.example.one_hundred_and_twenty_eighth.repositories;

import com.example.one_hundred_and_twenty_eighth.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
