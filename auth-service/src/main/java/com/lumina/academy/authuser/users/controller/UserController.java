package com.lumina.academy.authuser.users.controller;


import com.lumina.academy.authuser.shared.ApiConstants;
import com.lumina.academy.authuser.shared.ApiResponse;
import com.lumina.academy.authuser.users.dtos.UserResponse;
import com.lumina.academy.authuser.users.dtos.UsersCreate;
import com.lumina.academy.authuser.users.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(ApiConstants.USERS)
public class UserController {


    private final UserService _userService;

    public UserController(UserService userService) {
        _userService = userService;
    }

    @GetMapping()
    public ResponseEntity<ApiResponse<List<UserResponse>>> findAll() {
        var user = _userService.findAll();
        return ResponseEntity.ok(ApiResponse.success(user));
    }

    @GetMapping(ApiConstants.BY_EMAIL)
    public ResponseEntity<ApiResponse<UserResponse>> findUserByEmail(@RequestParam String email) {
//        var user = _userService.findByEmail(email);
//        return ResponseEntity.ok(ApiResponse.success(user));
        return ResponseEntity.ok(ApiResponse.success(_userService.findByEmail(email)));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<UserResponse>> createUser(@RequestBody @Valid UsersCreate user) {
        UserResponse created = _userService.insert(user);
        return ResponseEntity.ok(ApiResponse.success(created));

    }

    @GetMapping(ApiConstants.BY_ID)
    public ResponseEntity<ApiResponse<UserResponse>> getUserById(@PathVariable UUID id) {
        var user = _userService.findById(id);
        return ResponseEntity.ok(ApiResponse.success(user));
    }


}
