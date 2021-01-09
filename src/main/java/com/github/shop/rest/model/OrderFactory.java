package com.github.shop.rest.model;

import com.github.inchestnov.generatorstarter.AbstractFactory;
import com.github.inchestnov.generatorstarter.Holder;
import com.github.inchestnov.generatorstarter.utils.CommonRandom;
import com.github.shop.rest.data.generate.ProductsPool;
import com.github.shop.rest.data.generate.custom.CustomerHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class OrderFactory extends AbstractFactory<Order> {

    @Autowired
    private OrderHolder orderHolder;

    @Autowired
    private ProductsPool productsPool;

    @Autowired
    private CustomerHolder customerHolder;

    private static long number = 1L;

    private static String getNextNumber() {
        return String.format("sc-%05d", number++);
    }

    @Override
    protected Order createInstance() {
        return Order.builder()
                .name(productsPool.getRandomProduct())
                .number(getNextNumber())
                .customer(customerHolder.getRandom())
                .price(BigDecimal.valueOf(CommonRandom.getRandomDoubleBetween(0.0, 500_000.0)))
                .build();
    }

    @Override
    protected Holder<Order> getHolder() {
        return orderHolder;
    }
}
