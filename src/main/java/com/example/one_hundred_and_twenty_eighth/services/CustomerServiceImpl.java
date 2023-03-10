package com.example.one_hundred_and_twenty_eighth.services;

import com.example.one_hundred_and_twenty_eighth.models.Customer;
import com.example.one_hundred_and_twenty_eighth.repositories.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Slf4j    // logging doesn't work. Need to handle it
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Customer getById(Long id) {
//        log.info("IN CustomerServiceImpl getById {}", id);
        Optional<Customer> optC = customerRepository.findById(id);      //should be customerRepository.findOne(id); but something goes wrong
        return optC.orElse(null);
    }

    @Override
    public void save(Customer customer) {
//        log.info("IN CustomerServiceImpl save {}", customer);
        customerRepository.save(customer);
    }

    @Override
    public void delete(Long id) {
//        log.info("IN CustomerServiceImpl delete {}", id);
        customerRepository.deleteById(id);
    }
    @Override
    public List<Customer> getAll() {
//        log.info("IN CustomerServiceImpl getAll");
        return customerRepository.findAll();
    }

//    public void setCustomerRepository(CustomerRepository customerRepository) {
//        this.customerRepository = customerRepository;
//    }
}
