package com.example.tweteroo.exeption;

public class UsernameAlreadyExistsException extends RuntimeException {

    public UsernameAlreadyExistsException(String username) {
        super("User already registered");
    }
}
