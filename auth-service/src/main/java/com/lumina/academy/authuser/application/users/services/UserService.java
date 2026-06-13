package com.lumina.academy.authuser.application.users.services;

import com.lumina.academy.authuser.application.users.dtos.UserResponse;
import com.lumina.academy.authuser.application.users.dtos.UsersCreate;
import com.lumina.academy.authuser.domain.users.entities.Users;

import java.util.Enumeration;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {

    Optional<UserResponse> findByEmail(String email);

    Optional<UserResponse> findById(UUID id);

    Optional<UserResponse> findByUsername(String username, String lastName);

    List<UserResponse> findAll();

    UserResponse insert(UsersCreate users);

    UserResponse update(Users users);

    void delete(Users users);
}
