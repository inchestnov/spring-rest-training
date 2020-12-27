package com.github.shop.rest.controller;

import com.github.shop.rest.exception.CustomerNotFoundException;
import com.github.shop.rest.model.Customer;
import com.github.shop.rest.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public Customer findByNumber(@PathVariable Long id) throws CustomerNotFoundException {
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent())
            return customer.get();

        throw new CustomerNotFoundException(id);
    }

}
