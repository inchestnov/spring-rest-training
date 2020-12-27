package com.github.shop.rest.data;

import com.github.shop.rest.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {

    List<Order> findAll();

    Optional<Order> findByNumber(String number);

    <T extends Order> T save(T order);
}
