package com.example.restApi.exception;

public class UserNotFoundException extends Exception{
    private String message;

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException() {
    }
}
