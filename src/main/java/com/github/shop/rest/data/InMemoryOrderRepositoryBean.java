package com.github.shop.rest.data;

import com.github.shop.rest.model.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class InMemoryOrderRepositoryBean implements OrderRepository {

    private List<Order> orders = new ArrayList<>();

    @Override
    public List<Order> findAll() {
        return Collections.unmodifiableList(orders);
    }

    @Override
    public Optional<Order> findByNumber(String number) {
        return orders.stream().filter(o -> number.equals(o.getNumber())).findFirst();
    }

    @Override
    public <T extends Order> T save(T order) {
        orders.add(order);
        return order;
    }
}
