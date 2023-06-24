package com.example.jazs24260nbp.exceptions;

public class IncorrectDataException extends RuntimeException {
    public IncorrectDataException(String incorrectData) {
        super(incorrectData);
    }
}
