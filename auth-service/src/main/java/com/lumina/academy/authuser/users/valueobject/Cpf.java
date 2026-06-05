package com.lumina.academy.authuser.users.valueobject;

import com.lumina.academy.authuser.domain.exceptions.DomainException;

public record Cpf(String value) {

    public Cpf {
        if (value == null || !value.matches("\\d{11}")) throw new DomainException("CPF inválido: " + value);
    }
}
