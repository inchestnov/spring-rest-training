package com.github.shop.rest.data;

import com.github.shop.rest.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {

    List<Customer> findAll();

    Optional<Customer> findById(Long id);

    <T extends Customer> T save(T customer);
}
