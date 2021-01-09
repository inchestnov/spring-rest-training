package com.github.shop.rest.data;

import com.github.inchestnov.generatorstarter.Generator;
import com.github.shop.rest.model.Customer;
import com.github.shop.rest.model.Order;
import com.github.shop.rest.service.CustomerService;
import com.github.shop.rest.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class DataGenerator {

    private OrderService orderService;
    private CustomerService customerService;

    @Autowired
    private Generator generator;

    @Autowired
    public DataGenerator(OrderService orderService, CustomerService customerService) {
        this.orderService = orderService;
        this.customerService = customerService;
    }

    public void generate() {
        Customer alice = Customer.builder()
                .id(1L)
                .name("Alice")
                .build();

        Customer bob = Customer.builder()
                .id(2L)
                .name("Bob")
                .build();

        Customer mallory = Customer.builder()
                .id(3L)
                .name("Mallory")
                .build();

        List<Customer> customers = generator.generate(Customer.class, 5);

        customerService.save(alice);
        customerService.save(bob);
        customerService.save(mallory);
        customers.forEach(customerService::save);

        Order bag = Order.builder()
                .number("001")
                .name("Bag")
                .price(BigDecimal.valueOf(900.0))
                .customer(alice)
                .build();

        Order ball = Order.builder()
                .number("002")
                .name("ball")
                .price(BigDecimal.valueOf(850.0))
                .customer(alice)
                .build();

        Order laptop = Order.builder()
                .number("003")
                .name("laptop")
                .price(BigDecimal.valueOf(90_000.0))
                .customer(bob)
                .build();

        orderService.save(bag);
        orderService.save(ball);
        orderService.save(laptop);
    }

}
