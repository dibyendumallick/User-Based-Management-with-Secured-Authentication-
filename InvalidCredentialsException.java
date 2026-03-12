package com.example2.security;

// FIX 4: Custom exception for wrong password — maps to 401 Unauthorized
public class InvalidCredentialsException extends RuntimeException {

    public InvalidCredentialsException(String message) {
        super(message);
    }
}