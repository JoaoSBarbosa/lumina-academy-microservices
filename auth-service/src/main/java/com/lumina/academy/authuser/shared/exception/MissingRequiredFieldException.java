package com.lumina.academy.authuser.shared.exception;

public class MissingRequiredFieldException extends RuntimeException {

    public MissingRequiredFieldException(String message) {
        super(message);
    }
}
