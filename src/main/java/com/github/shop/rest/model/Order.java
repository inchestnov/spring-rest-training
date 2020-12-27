package com.github.shop.rest.model;

import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {

    private String number;
    private String name;
    private BigDecimal price;

    private Customer customer;

}
