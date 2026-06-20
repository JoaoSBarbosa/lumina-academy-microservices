package com.lumina.academy.authuser.user.application.dto.request;

import com.lumina.academy.authuser.user.domain.enums.UserGender;
import com.lumina.academy.authuser.user.domain.enums.UserStatus;
import com.lumina.academy.authuser.user.domain.enums.UserType;
import com.lumina.academy.authuser.user.domain.vo.PhoneNumber;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UpdateUserRequest {


    @NotBlank(message = "Primeiro nome é obrigatorio")
    private String firstName;

    @NotBlank(message = "Sobrenome é obrigatorio")
    private String lastName;

    @NotBlank(message = "Email é obrigatorio")
    private String email;

    @NotBlank(message = "CPF é obrigatorio")
    private String cpf;

    @NotNull(message = "Tipo de cadastro é obrigatorio")
    private UserType userType;

    private LocalDate birthDate;
    @NotNull(message = "Status é obrigatorio")
    private UserStatus status;
    private UserGender gender;
    private String phoneNumber;

    public UpdateUserRequest() {
    }

    public UpdateUserRequest(String firstName, String phoneNumber, UserGender gender, UserStatus status, LocalDate birthDate, UserType userType, String cpf, String email, String lastName) {
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.status = status;
        this.birthDate = birthDate;
        this.userType = userType;
        this.cpf = cpf;
        this.email = email;
        this.lastName = lastName;
    }


}
