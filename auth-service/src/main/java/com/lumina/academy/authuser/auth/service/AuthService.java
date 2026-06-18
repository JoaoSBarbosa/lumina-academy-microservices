package com.lumina.academy.authuser.auth.service;

import com.lumina.academy.authuser.user.application.dto.UserCreateRequest;
import com.lumina.academy.authuser.user.application.dto.UserResponse;

public interface AuthService {

    UserResponse register(UserCreateRequest users);

    boolean existsByUserNameOrEmail(String email, String username);


}
