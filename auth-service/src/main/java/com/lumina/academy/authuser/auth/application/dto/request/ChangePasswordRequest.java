package com.lumina.academy.authuser.auth.application.dto.request;

import jakarta.validation.constraints.NotBlank;


public class ChangePasswordRequest {

    @NotBlank(message = "Senha é obrigatoria")
    private String password;
    @NotBlank(message = "Confirmação da senha é obrigatório")
    private String confirmPassword;

    @NotBlank(message = "Confirmação da senha antiga é obrigatório")
    private String oldPassword;
}
