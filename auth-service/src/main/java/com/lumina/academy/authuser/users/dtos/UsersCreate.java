package com.lumina.academy.authuser.users.dtos;

import com.lumina.academy.authuser.users.entity.enums.UserType;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersCreate {
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
    @NotBlank(message = "Tipo de cadastro é obrigatorio")
    private UserType userType;


    public UsersCreate(
            String firstName,
            String lastName,
            String email,
            String password,
            String confirmPassword,
            String cpf,
            UserType userType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.cpf = cpf;
        this.userType = userType;
    }
}
