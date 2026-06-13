package com.lumina.academy.authuser.api.controllers;


import com.lumina.academy.authuser.application.users.dtos.UserResponse;
import com.lumina.academy.authuser.application.users.dtos.UsersCreate;
import com.lumina.academy.authuser.application.users.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {


    private final UserService _userService;

    public UserController(UserService userService) {
        _userService = userService;
    }

    @GetMapping()
    public ResponseEntity<List<UserResponse>> findAll() {
        var user = _userService.findAll();
        return ResponseEntity.ok(user);
    }

    @GetMapping("/email")
    public ResponseEntity<UserResponse> findUserByEmail(@RequestParam String email) {
        var user = _userService.findByEmail(email);
        return ResponseEntity.ok(user.orElse(null));
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UsersCreate user) {
        var response = _userService.insert(user);
        URI location = URI.create("/users/" + response.id());
        return ResponseEntity.created(location).body(response);

    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable UUID id) {
        var user = _userService.findById(id);
        return ResponseEntity.ok(user.orElse(null));
    }


}
