package com.github.shop.rest.data;

import com.github.shop.rest.model.Customer;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
public class InMemoryCustomerRepositoryBean implements CustomerRepository {

    private List<Customer> customers = new ArrayList<>();

//    private static Long id = 1L;
//
//    private static Long getNextId() {
//        return id++;
//    }
//
//    @PostConstruct
//    private void init() {
//        Customer alice = Customer.builder()
//                .id(getNextId())
//                .name("Alice")
//                .build();
//
//        Customer bob = Customer.builder()
//                .id(getNextId())
//                .name("Bob")
//                .build();
//
//        Customer mallory = Customer.builder()
//                .id(getNextId())
//                .name("Mallory")
//                .build();
//
//        customers.addAll(Arrays.asList(alice, bob, mallory));
//    }

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
