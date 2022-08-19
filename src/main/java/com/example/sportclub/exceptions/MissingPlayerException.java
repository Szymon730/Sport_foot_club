package com.example.sportclub.exceptions;

public class MissingPlayerException extends RuntimeException {
    public MissingPlayerException(String message) {
        super(message);
    }
}
