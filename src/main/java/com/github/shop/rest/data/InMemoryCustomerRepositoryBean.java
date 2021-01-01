package com.github.shop.rest.data;

import com.github.shop.rest.model.Customer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class InMemoryCustomerRepositoryBean implements CustomerRepository {

    private List<Customer> customers = new ArrayList<>();

    @Override
    public List<Customer> findAll() {
        return Collections.unmodifiableList(customers);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customers.stream()
                .filter(c -> id.equals(c.getId()))
                .findFirst();
    }

    @Override
    public <T extends Customer> T save(T customer) {
        customers.add(customer);
        return customer;
    }
}
