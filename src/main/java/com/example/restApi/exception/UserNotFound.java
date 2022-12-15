package com.example.restApi.exception;

public class UserNotFound extends Exception{
    private String message;

    public UserNotFound(String message) {
        super(message);
    }
}
