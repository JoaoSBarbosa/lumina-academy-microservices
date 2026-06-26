package com.lumina.academy.authuser.user.domain.validations.impl;

import com.lumina.academy.authuser.user.domain.validations.UserNameConstraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UserNameConstraintImpl implements ConstraintValidator<UserNameConstraint, String> {

    @Override
    public void initialize(UserNameConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        return username != null && !username.trim().isBlank() && !username.contains(" ");
    }
}
