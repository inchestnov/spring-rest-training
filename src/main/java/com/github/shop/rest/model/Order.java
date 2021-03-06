package com.github.shop.rest.model;

import com.github.inchestnov.generatorstarter.Generated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Generated(factory = OrderFactory.class)
public class Order {

    private String number;
    private String name;
    private BigDecimal price;

    private Customer customer;

}
