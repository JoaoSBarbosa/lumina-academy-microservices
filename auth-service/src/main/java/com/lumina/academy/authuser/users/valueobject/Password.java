package com.lumina.academy.authuser.users.valueobject;

import com.lumina.academy.authuser.domain.exceptions.DomainException;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;


@Embeddable
public record Password(@Column(name = "senha") String value) {

    public Password {
        if (value == null || value.length() < 6)
            throw new DomainException("A senha deve conter pelo menos 6 caracteres.");
    }

}
