package com.example.jazs24260nbp.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String notFoundRate) {
        super(notFoundRate);
    }
}
