package com.shopme.shopme.user;

public class UserNotFoundException extends  Exception{
    public UserNotFoundException(String message) {
        super(message);
    }
}
