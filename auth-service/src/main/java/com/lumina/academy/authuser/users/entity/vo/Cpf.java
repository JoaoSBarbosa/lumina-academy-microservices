package com.lumina.academy.authuser.users.entity.vo;

import com.lumina.academy.authuser.exceptions.BusinessException;

public record Cpf(String value) {

    public Cpf {
        if (value == null || !value.matches("\\d{11}")) throw new BusinessException("CPF inválido: " + value);
    }

    public static Cpf toCpf(String cpf) {
        if (cpf == null) return null;
        return new Cpf(cpf);
    }

    public String getValue() {
        return this.value;
    }
}
