package com.github.shop.rest.model;

import com.github.inchestnov.generatorstarter.Generated;
import com.github.shop.rest.data.generate.custom.CustomerFactory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Generated(factory = CustomerFactory.class)
public class Customer {

    private Long id;
    private String name;

}
