package com.lumina.academy.authuser.user.domain.vo;

import com.lumina.academy.authuser.shared.exception.BusinessException;


public record Password(String value) {

    public Password {
        if (value == null || value.length() < 6)
            throw new BusinessException("A senha deve conter pelo menos 6 caracteres.");
    }

    public static Password toPassword(String password) {
        if (password == null) return null;
        return new Password(password);
    }

    public String getValue() {
        return this.value;
    }

}
