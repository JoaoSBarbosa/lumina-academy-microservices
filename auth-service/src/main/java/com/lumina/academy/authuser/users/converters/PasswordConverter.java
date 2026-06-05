package com.lumina.academy.authuser.users.converters;

import com.lumina.academy.authuser.users.valueobject.Password;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PasswordConverter implements AttributeConverter<Password, String> {

    @Override
    public String convertToDatabaseColumn(Password password) {
        return password == null ? null : password.value();
    }

    @Override
    public Password convertToEntityAttribute(String password) {
        return password == null ? null : new Password(password);
    }
}
