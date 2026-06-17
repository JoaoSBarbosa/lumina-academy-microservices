package com.lumina.academy.authuser.user.domain.vo;

import com.lumina.academy.authuser.shared.exception.BusinessException;


public record Email(String value) {

    public Email {
        if (value == null || !value.matches("^[A-Za-z0-9+_.-]+@(.+)$"))
            throw new BusinessException("Email inválido: " + value);
    }

    public static Email toEmail(String email) {
        if (email == null) return null;
        return new Email(email);
    }

    public String getValue() {
        return this.value;
    }

}
