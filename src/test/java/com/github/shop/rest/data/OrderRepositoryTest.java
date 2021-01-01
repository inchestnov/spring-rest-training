package com.github.shop.rest.data;

import com.github.shop.rest.model.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class OrderRepositoryTest {

    private OrderRepository orderRepository = new InMemoryOrderRepositoryBean();

    @BeforeEach
    private void setup() {
        Order bag = Order.builder()
                .number("001")
                .name("Bag")
                .price(BigDecimal.valueOf(900.0))
                .build();

        Order ball = Order.builder()
                .number("002")
                .name("ball")
                .price(BigDecimal.valueOf(850.0))
                .build();

        Order laptop = Order.builder()
                .number("003")
                .name("laptop")
                .price(BigDecimal.valueOf(90_000.0))
                .build();

        orderRepository.save(bag);
        orderRepository.save(ball);
        orderRepository.save(laptop);
    }

    @DisplayName("OrderRepository#findAll")
    @Test
    void findAll() {
        List<Order> all = orderRepository.findAll();

        assertEquals(all.size(), 3);
    }

    @DisplayName("OrderRepository#findByNumber")
    @Test
    void findByNumber() {
        Optional<Order> bag = orderRepository.findByNumber("001");

        assertEquals(bag.isPresent(), Boolean.TRUE);
        assertEquals(bag.get().getNumber(), "001");

        Optional<Order> undefine = orderRepository.findByNumber("004");
        assertEquals(undefine.isEmpty(), Boolean.TRUE);
    }

    @DisplayName("OrderRepository#save")
    @Test
    void save() {
        Order apple = Order.builder()
                .number("004")
                .name("Apple")
                .price(BigDecimal.valueOf(100.0))
                .build();

        Order returned = orderRepository.save(apple);
        assertEquals(returned.getNumber(), "004");
        assertEquals(returned.getName(), "Apple");

        Optional<Order> reloadedApple = orderRepository.findByNumber("004");
        assertEquals(reloadedApple.isPresent(), Boolean.TRUE);
        assertEquals(reloadedApple.get().getNumber(), "004");
        assertEquals(reloadedApple.get().getName(), "Apple");

        assertEquals(orderRepository.findAll().size(), 4);
    }

}