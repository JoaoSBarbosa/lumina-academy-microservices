package com.lumina.academy.authuser.user.application.dto.response;


import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record UserResponse(
        UUID id,
        String userName,
        String firstName,
        String lastName,
        String email,
        String phoneNumber,
        String cpf,
        String gender,
        String imageUrl,
        String status,
        String userType,
        LocalDate birthDate,
        LocalDateTime createdAt,
        LocalDateTime updateAt) {

}



