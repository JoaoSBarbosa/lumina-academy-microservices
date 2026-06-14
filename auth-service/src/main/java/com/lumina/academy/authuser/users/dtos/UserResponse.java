package com.lumina.academy.authuser.users.dtos;


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



