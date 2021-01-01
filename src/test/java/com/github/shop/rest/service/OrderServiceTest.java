package com.github.shop.rest.service;

import com.github.shop.rest.data.OrderRepository;
import com.github.shop.rest.model.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService = new OrderServiceBean();

    @BeforeEach
    void setMockOutput() {
        Order apple = Order.builder()
                .number("001")
                .name("Apple")
                .build();

        Mockito.when(orderRepository.findByNumber("001")).thenReturn(Optional.of(apple));
    }

    @Test
    @DisplayName("OrderService#findByNumber")
    void findByNumber() {
        Optional<Order> apple = orderRepository.findByNumber("001");
        assertEquals(apple.isPresent(), Boolean.TRUE);

        Order appleOrder = apple.get();
        assertEquals(appleOrder.getNumber(), "001");
        assertEquals(appleOrder.getName(), "Apple");

        Optional<Order> undefine = orderRepository.findByNumber("002");
        assertEquals(undefine.isEmpty(), Boolean.TRUE);
    }

}