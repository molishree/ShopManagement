package com.shop_management.shop_management.exception;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message) {

        super(message);
    }
}
