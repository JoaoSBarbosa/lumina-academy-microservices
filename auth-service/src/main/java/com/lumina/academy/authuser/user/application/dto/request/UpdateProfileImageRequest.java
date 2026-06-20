package com.lumina.academy.authuser.user.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class UpdateProfileImageRequest {
    
    @NotNull(message = "User ID é obrigatorio")
    private UUID userId;
    @NotBlank(message = "URL da imagem é obrigatorio")
    private String imageUrl;
}
