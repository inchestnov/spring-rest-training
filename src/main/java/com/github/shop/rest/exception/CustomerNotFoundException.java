package com.github.shop.rest.exception;

public class CustomerNotFoundException extends Exception {

    public CustomerNotFoundException() {
        super();
    }

    public CustomerNotFoundException(Long id) {
        super("Customer with id '" + id + "' not found");
    }

}
