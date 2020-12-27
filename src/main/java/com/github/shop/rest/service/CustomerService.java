package com.github.shop.rest.service;

import com.github.shop.rest.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    List<Customer> findAll();

    Optional<Customer> findById(Long id);

    <T extends Customer> T save(T customer);

}
