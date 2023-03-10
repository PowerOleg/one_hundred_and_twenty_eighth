package com.example.one_hundred_and_twenty_eighth.rest_controllers;

import com.example.one_hundred_and_twenty_eighth.models.Customer;
import com.example.one_hundred_and_twenty_eighth.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers/")
public class CustomerRestControllerV1 {
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long customerId) {
        if (customerId == null) {
            return new ResponseEntity<Customer>(HttpStatus.BAD_REQUEST);
        } else {
            Customer customer = this.customerService.getById(customerId);
            if (customer == null) {
                return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
            } else return new ResponseEntity<Customer>(customer, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> saveCustomer(@RequestBody @Validated Customer customer) {
        HttpHeaders headers = new HttpHeaders();
        if (customer == null) {
            return new ResponseEntity<Customer>(HttpStatus.BAD_REQUEST);
        } else {
            this.customerService.save(customer);
            return new ResponseEntity<Customer>(customer, headers, HttpStatus.CREATED);  //что еще засунем?
        }
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> updateCustomer(@RequestBody @Validated Customer customer,
                                                   UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();
        if (customer == null) {
            return new ResponseEntity<Customer>(HttpStatus.BAD_REQUEST);
        } else {
            this.customerService.save(customer);
            return new ResponseEntity<Customer>(customer, headers, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") Long id) {
        Customer customer = this.customerService.getById(id);
        if (customer == null) {
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        } else {
            this.customerService.delete(id);
            return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = this.customerService.getAll();
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            System.out.println(customers);
            return new ResponseEntity<>(customers, HttpStatus.OK);
//            return ResponseEntity.ok().body(customers);
        }
    }
}