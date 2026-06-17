package com.lumina.academy.authuser.user.application.dto;

import com.lumina.academy.authuser.user.domain.enums.UserType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateRequest {
    @NotBlank(message = "Primeiro nome é obrigatorio")
    private String firstName;

    @NotBlank(message = "Username é obrigatorio")
    private String userName;


    @NotBlank(message = "Sobrenome é obrigatorio")
    private String lastName;
    @NotBlank(message = "Email é obrigatorio")
    private String email;

    @NotBlank(message = "Senha é obrigatoria")
    private String password;
    @NotBlank(message = "Confirmação da senha é obrigatório")
    private String confirmPassword;
    @NotBlank(message = "CPF é obrigatorio")
    private String cpf;
    @NotNull(message = "Tipo de cadastro é obrigatorio")
    private UserType userType;

    public UserCreateRequest() {
    }

    public UserCreateRequest(
            String firstName,
            UserType userType,
            String cpf,
            String confirmPassword,
            String lastName,
            String password,
            String email,
            String userName) {
        this.firstName = firstName;
        this.userType = userType;
        this.cpf = cpf;
        this.confirmPassword = confirmPassword;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.userName = userName;
    }
}
