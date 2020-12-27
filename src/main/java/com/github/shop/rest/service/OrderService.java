package com.github.shop.rest.service;

import com.github.shop.rest.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    List<Order> findAll();

    Optional<Order> findByNumber(String number);

    <T extends Order> T save(T order);

}
