package com.lumina.academy.authuser.users.valueobject;

import com.lumina.academy.authuser.domain.exceptions.DomainException;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;


public record Email(String value) {

    public Email {
        if (value == null || !value.matches("^[A-Za-z0-9+_.-]+@(.+)$"))
            throw new DomainException("Email inválido: " + value);
    }

}
