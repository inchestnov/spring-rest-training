package com.github.shop.rest.controller;

import com.github.shop.rest.exception.OrderNotFoundException;
import com.github.shop.rest.model.Order;
import com.github.shop.rest.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> findAll() {
        return orderService.findAll();
    }

    @GetMapping("/{number}")
    public Order findByNumber(@PathVariable String number) throws OrderNotFoundException {
        Optional<Order> order = orderService.findByNumber(number);
        if (order.isPresent())
            return order.get();

        throw new OrderNotFoundException(number);
    }

}
