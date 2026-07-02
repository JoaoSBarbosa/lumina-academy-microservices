package com.lumina.academy.authuser.auth.application.validations;

import com.lumina.academy.authuser.auth.application.validations.impl.PasswordMatchesImpl;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordMatchesImpl.class)
public @interface PasswordMatches {

    String password();

    String confirmPassword();

    String message() default "Senha e confirmação de senha não conferem";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
