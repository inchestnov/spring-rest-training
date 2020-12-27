package com.github.shop.rest.service;

import com.github.shop.rest.data.OrderRepository;
import com.github.shop.rest.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class OrderServiceBean implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findByNumber(String number) {
        return orderRepository.findByNumber(number);
    }

    @Override
    public <T extends Order> T save(T order) {
        return orderRepository.save(order);
    }
}
