package com.lumina.academy.authuser.users.entity.converters;

import com.lumina.academy.authuser.users.entity.vo.PhoneNumber;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PhoneNumberConverter implements AttributeConverter<PhoneNumber, String> {

    @Override
    public String convertToDatabaseColumn(PhoneNumber phoneNumber) {
        return phoneNumber == null ? null : phoneNumber.value();
    }

    @Override
    public PhoneNumber convertToEntityAttribute(String value) {
        return value == null ? null : new PhoneNumber(value);
    }


}
