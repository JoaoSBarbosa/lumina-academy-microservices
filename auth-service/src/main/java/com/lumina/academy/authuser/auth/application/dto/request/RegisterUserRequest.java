package com.lumina.academy.authuser.auth.application.dto.request;

import com.lumina.academy.authuser.user.domain.enums.UserStatus;
import com.lumina.academy.authuser.user.domain.enums.UserType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class RegisterUserRequest {


    @NotBlank(message = "Username é obrigatorio")
    private String userName;

    @NotBlank(message = "Primeiro nome é obrigatorio")
    private String firstName;

    @NotBlank(message = "Sobrenome é obrigatorio")
    private String lastName;

    @NotBlank(message = "Email é obrigatorio")
    private String email;

    @NotBlank(message = "Senha é obrigatoria")
    private String password;

    @NotBlank(message = "CPF é obrigatorio")
    private String cpf;

    @NotNull(message = "Tipo de cadastro é obrigatorio")
    private UserType userType;
    private UserStatus status;

    public RegisterUserRequest() {
    }

    public RegisterUserRequest(
            String firstName,
            UserType userType,
            String cpf,
            String lastName,
            String password,
            String email,
            String userName,
            UserStatus status) {
        this.firstName = firstName;
        this.userType = userType;
        this.cpf = cpf;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.userName = userName;
        this.status = status;
    }
}
