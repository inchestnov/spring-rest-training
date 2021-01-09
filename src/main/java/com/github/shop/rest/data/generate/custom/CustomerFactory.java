package com.github.shop.rest.data.generate.custom;

import com.github.inchestnov.generatorstarter.AbstractFactory;
import com.github.inchestnov.generatorstarter.Holder;
import com.github.inchestnov.generatorstarter.NamePool;
import com.github.shop.rest.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerFactory extends AbstractFactory<Customer> {

    @Autowired
    private NamePool namePool;

    @Autowired
    private CustomerHolder customerHolder;

    private static long long_counter = 1;

    @Override
    protected Customer createInstance() {
        return new Customer(long_counter++, namePool.getRandomName());
    }

    @Override
    protected Holder<Customer> getHolder() {
        return customerHolder;
    }
}
