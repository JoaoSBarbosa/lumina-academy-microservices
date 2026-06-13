package com.lumina.academy.authuser.domain.users.valueobjects;

import com.lumina.academy.authuser.domain.exceptions.DomainException;

public record Cpf(String value) {

    public Cpf {
        if (value == null || !value.matches("\\d{11}")) throw new DomainException("CPF inválido: " + value);
    }

    public static Cpf toCpf(String cpf) {
        if (cpf == null) return null;
        return new Cpf(cpf);
    }

    public String getValue() {
        return this.value;
    }
}
