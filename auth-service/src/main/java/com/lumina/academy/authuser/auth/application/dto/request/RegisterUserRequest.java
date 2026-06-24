package com.lumina.academy.authuser.auth.application.dto.request;

import com.lumina.academy.authuser.user.domain.enums.UserStatus;
import com.lumina.academy.authuser.user.domain.enums.UserType;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class RegisterUserRequest {


    @NotBlank(message = "Username é obrigatorio")
    @Size(min = 4, max = 50, message = "Username deve ter entre 4 e 50 caracteres")
    private String userName;

    @NotBlank(message = "Primeiro nome é obrigatorio")
    @Size(min = 2, max = 200, message = "Primeiro nome deve ter entre 2 e 200 caracteres")
    private String firstName;

    @NotBlank(message = "Sobrenome é obrigatorio")
    @Size(min = 2, max = 200, message = "Sobrenome deve ter entre 2 e 200 caracteres")
    private String lastName;

    @NotBlank(message = "Email é obrigatorio")
    @Email(message = "Formato de email inválido")
    private String email;

    @NotBlank(message = "Senha é obrigatoria")
    @Size(min = 5, max = 200, message = "Senha deve ter entre 8 e 100 caracteres")
    private String password;

    @NotBlank(message = "CPF é obrigatorio")
    @Pattern(regexp = "\\d{11}", message = "CPF deve conter exatamente 11 dígitos")
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
