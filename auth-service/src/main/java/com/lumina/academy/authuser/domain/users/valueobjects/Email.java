package com.lumina.academy.authuser.domain.users.valueobjects;

import com.lumina.academy.authuser.domain.exceptions.DomainException;


public record Email(String value) {

    public Email {
        if (value == null || !value.matches("^[A-Za-z0-9+_.-]+@(.+)$"))
            throw new DomainException("Email inválido: " + value);
    }

    public static Email toEmail(String email) {
        if (email == null) return null;
        return new Email(email);
    }

    public String getValue() {
        return this.value;
    }

}
