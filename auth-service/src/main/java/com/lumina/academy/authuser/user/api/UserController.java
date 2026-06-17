package com.lumina.academy.authuser.user.api;


import com.lumina.academy.authuser.shared.api.ApiResponse;
import com.lumina.academy.authuser.user.application.dto.UserResponse;
import com.lumina.academy.authuser.user.application.dto.UserCreateRequest;
import com.lumina.academy.authuser.user.application.service.UserService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/users")
public class UserController {


    private final UserService _userService;

    public UserController(UserService userService) {
        _userService = userService;
    }

    @GetMapping()
    public ResponseEntity<ApiResponse<List<UserResponse>>> findAll(@RequestParam(required = false) UUID userId, Pageable pageable) {
        List<UserResponse> users = _userService.findAll(pageable, userId);
        return ResponseEntity.ok(ApiResponse.success(users));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<ApiResponse<UserResponse>> findUserByEmail(@RequestParam String email) {
        UserResponse user = _userService.findByEmail(email);
        return ResponseEntity.ok(ApiResponse.success(user));
    }


    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponse>> getUserById(@PathVariable UUID id) {
        UserResponse user = _userService.findById(id);
        return ResponseEntity.ok(ApiResponse.success(user));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse<Void>> deleteUser(@PathVariable UUID userId) {
        _userService.delete(userId);
        return ResponseEntity.ok(ApiResponse.success(null, "Usuário deletado com sucesso", HttpStatus.NO_CONTENT.value()));
    }


}
