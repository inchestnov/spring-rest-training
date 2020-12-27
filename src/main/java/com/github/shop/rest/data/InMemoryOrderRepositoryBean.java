package com.github.shop.rest.data;

import com.github.shop.rest.model.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.*;

@Component
public class InMemoryOrderRepositoryBean implements OrderRepository {

    private List<Order> orders = new ArrayList<>();

    private static long number = 1;

    private static String getNextNumber() {
        return String.valueOf(number++);
    }

    @PostConstruct
    private void init() {
        Order bag = Order.builder()
                .number(getNextNumber())
                .name("Bag")
                .price(BigDecimal.valueOf(900.0))
                .build();

        Order ball = Order.builder()
                .number(getNextNumber())
                .name("ball")
                .price(BigDecimal.valueOf(850.0))
                .build();

        Order laptop = Order.builder()
                .number(getNextNumber())
                .name("laptop")
                .price(BigDecimal.valueOf(90_000.0))
                .build();

        orders.addAll(Arrays.asList(bag, ball, laptop));
    }

    @Override
    public List<Order> findAll() {
        return Collections.unmodifiableList(orders);
    }

    @Override
    public Optional<Order> findByNumber(String number) {
        return orders.stream().filter(o -> number.equals(o.getNumber())).findFirst();
    }
}
