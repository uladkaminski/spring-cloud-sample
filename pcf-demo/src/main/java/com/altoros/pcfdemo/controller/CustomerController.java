package com.altoros.pcfdemo.controller;

import com.altoros.pcfdemo.model.Customer;
import com.altoros.pcfdemo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @PutMapping("/customer")
    public Customer putCustomer(@RequestBody Customer customer){
        Customer savedCustomer = customerRepository.save(customer);
        return savedCustomer;
    }

    @GetMapping("/customer")
    public List<Customer> getCustomer(@RequestParam String lastName){
        return customerRepository.findByLastName(lastName);
    }
}
