package com.rohit.academics.exception;

public class WrongPasswordException extends RuntimeException {
    public WrongPasswordException(String wrongPassword) {
        super(wrongPassword);
    }
}
