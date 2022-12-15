package com.example.restApi.exception;

public class UserExistException extends Exception{
    private String message;
    public UserExistException(String message) {
        this.message=message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
