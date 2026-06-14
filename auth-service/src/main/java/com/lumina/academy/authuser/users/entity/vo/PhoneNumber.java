package com.lumina.academy.authuser.users.entity.vo;

import com.lumina.academy.authuser.exceptions.BusinessException;

public record PhoneNumber(String value) {


    public PhoneNumber {
        validate(value);
    }

    private void validate(String value) {
        if (value == null || value.isBlank()) throw new BusinessException("Telefone é obrigatório.");

        String digits = value.replaceAll("\\D", "");
        if (digits.length() < 10 || digits.length() > 11)
            throw new BusinessException("Telefone deve conter entre 10 e 11 dígitos.");
    }

    public static PhoneNumber toPhone(String phoneNumber) {
        if (phoneNumber == null) return null;
        return new PhoneNumber(phoneNumber);
    }

    public String getValue() {
        return this.value;
    }
}
