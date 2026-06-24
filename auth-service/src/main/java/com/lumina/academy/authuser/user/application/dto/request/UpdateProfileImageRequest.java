package com.lumina.academy.authuser.user.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UpdateProfileImageRequest {


    @NotBlank(message = "URL da imagem é obrigatorio")
    private String imageUrl;

    public UpdateProfileImageRequest() {
    }

    public UpdateProfileImageRequest(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
