package com.github.shop.rest;

import com.github.shop.rest.data.DataGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RestApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(RestApplication.class, args);

        DataGenerator dataGenerator = context.getBean(DataGenerator.class);
        dataGenerator.generate();
    }

}
