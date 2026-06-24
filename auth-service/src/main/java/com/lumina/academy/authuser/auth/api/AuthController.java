package com.lumina.academy.authuser.auth.api;


import com.lumina.academy.authuser.auth.application.dto.request.ChangePasswordRequest;
import com.lumina.academy.authuser.auth.application.dto.request.RegisterUserRequest;
import com.lumina.academy.authuser.auth.application.service.AuthService;
import com.lumina.academy.authuser.shared.api.ApiResponse;
import com.lumina.academy.authuser.user.application.dto.response.UserResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/auth")
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<UserResponse>> register(@RequestBody @Valid RegisterUserRequest user) {
        UserResponse created = authService.register(user);
        return ResponseEntity.ok(ApiResponse.success(created));

    }

    @PutMapping("/{userId}/password")
    public ResponseEntity<ApiResponse<UserResponse>> changePassword(@Valid @RequestBody ChangePasswordRequest passwordRequest, @PathVariable UUID userId) {
        authService.alterPassword(passwordRequest, userId);
        return ResponseEntity.ok(ApiResponse.success(null, "Senha atualizada com sucesso"));
    }
}
