package com.lumina.academy.authuser.auth.application.service;

import com.lumina.academy.authuser.auth.application.dto.request.ChangePasswordRequest;
import com.lumina.academy.authuser.auth.application.dto.request.RegisterUserRequest;
import com.lumina.academy.authuser.user.application.dto.response.UserResponse;

import java.util.UUID;

public interface AuthService {

    UserResponse register(RegisterUserRequest register);


    boolean existsByUserNameOrEmail(String email, String username);

    void alterPassword(ChangePasswordRequest passwordRequest, UUID id);

}
