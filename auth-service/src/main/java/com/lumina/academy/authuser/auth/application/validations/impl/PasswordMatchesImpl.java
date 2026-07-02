package com.lumina.academy.authuser.auth.application.validations.impl;

import com.lumina.academy.authuser.auth.application.validations.PasswordMatches;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.util.Objects;

public class PasswordMatchesImpl implements ConstraintValidator<PasswordMatches, Object> {

    private String passwordField;
    private String confirmPasswordField;

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {

        passwordField = constraintAnnotation.password();
        confirmPasswordField = constraintAnnotation.confirmPassword();

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        BeanWrapper wrapper = new BeanWrapperImpl(value);

        Object password = wrapper.getPropertyValue(passwordField);
        Object confirmPassword = wrapper.getPropertyValue(confirmPasswordField);

        if (Objects.equals(password, confirmPassword)) return true;

        context.disableDefaultConstraintViolation();

        context.buildConstraintViolationWithTemplate(
                        "Senha e confirmação de senha não conferem")
                .addPropertyNode(confirmPasswordField)
                .addConstraintViolation();
        return false;
    }
}
