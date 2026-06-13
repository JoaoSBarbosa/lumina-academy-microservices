package com.lumina.academy.authuser.application.users.dtos;


import com.lumina.academy.authuser.domain.users.valueobjects.PhoneNumber;


import java.time.LocalDate;
import java.util.UUID;

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
        LocalDate birthDate) {

}



