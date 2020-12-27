package com.github.shop.rest.exception;

public class OrderNotFoundException extends Exception {

    public OrderNotFoundException() {
        super();
    }

    public OrderNotFoundException(String number) {
        super("Order with number '" + number + "' not found");
    }

}
