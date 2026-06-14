package com.lumina.academy.authuser.users.services;

import com.lumina.academy.authuser.users.dtos.UserResponse;
import com.lumina.academy.authuser.users.dtos.UsersCreate;
import com.lumina.academy.authuser.users.entity.Users;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {

    UserResponse findByEmail(String email);

    UserResponse findById(UUID id);

    UserResponse findByUsername(String username, String lastName);

    List<UserResponse> findAll();

    UserResponse insert(UsersCreate users);

    UserResponse update(Users users);

    void delete(Users users);
}
