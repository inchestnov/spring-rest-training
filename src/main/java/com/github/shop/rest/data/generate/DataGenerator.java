package com.github.shop.rest.data.generate;

import com.github.inchestnov.generatorstarter.Generator;
import com.github.shop.rest.model.Customer;
import com.github.shop.rest.model.Order;
import com.github.shop.rest.service.CustomerService;
import com.github.shop.rest.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private Generator generator;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        generator.generate(Customer.class, 5).forEach(customerService::save);
        generator.generate(Order.class, 25).forEach(orderService::save);
    }

}
