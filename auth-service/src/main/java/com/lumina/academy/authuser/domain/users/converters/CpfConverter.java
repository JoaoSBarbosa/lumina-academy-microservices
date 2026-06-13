package com.lumina.academy.authuser.domain.users.converters;

import com.lumina.academy.authuser.domain.users.valueobjects.Cpf;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;


@Converter(autoApply = true)
public class CpfConverter implements AttributeConverter<Cpf, String> {
    @Override
    public String convertToDatabaseColumn(Cpf attribute) {
        return attribute == null ? null : attribute.value();
    }

    @Override
    public Cpf convertToEntityAttribute(String value) {
        return value == null ? null : new Cpf(value);
    }
}
