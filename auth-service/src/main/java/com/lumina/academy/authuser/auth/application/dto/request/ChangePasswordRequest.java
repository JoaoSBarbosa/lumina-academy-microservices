package com.lumina.academy.authuser.auth.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class ChangePasswordRequest {

    @NotBlank(message = "Senha é obrigatoria")
    @Size(min = 5, max = 200, message = "Senha deve ter entre 8 e 100 caracteres")
    private String password;

    @NotBlank(message = "Confirmação da senha é obrigatório")
    @Size(min = 5, max = 200, message = "Confirmação da senha deve ter entre 8 e 100 caracteres")
    private String confirmPassword;

    @NotBlank(message = "Confirmação da senha antiga é obrigatório")
    @Size(min = 5, max = 200, message = "Senha antiga deve ter entre 8 e 100 caracteres")
    private String oldPassword;

    public ChangePasswordRequest(String password, String confirmPassword, String oldPassword) {
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.oldPassword = oldPassword;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ChangePasswordRequest that = (ChangePasswordRequest) o;
        return Objects.equals(password, that.password) && Objects.equals(confirmPassword, that.confirmPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(password, confirmPassword);
    }
}
