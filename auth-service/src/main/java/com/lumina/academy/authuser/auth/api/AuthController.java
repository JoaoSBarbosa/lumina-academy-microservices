package com.lumina.academy.authuser.auth.api;


import com.lumina.academy.authuser.auth.service.AuthService;
import com.lumina.academy.authuser.shared.api.ApiResponse;
import com.lumina.academy.authuser.user.application.dto.UserCreateRequest;
import com.lumina.academy.authuser.user.application.dto.UserResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/auth")
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<UserResponse>> register(@RequestBody @Valid UserCreateRequest user) {
        UserResponse created = authService.register(user);
        return ResponseEntity.ok(ApiResponse.success(created));

    }
}
