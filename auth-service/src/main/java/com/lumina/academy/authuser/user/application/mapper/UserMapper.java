package com.lumina.academy.authuser.user.application.mapper;

import com.lumina.academy.authuser.auth.application.dto.request.RegisterUserRequest;
import com.lumina.academy.authuser.user.application.dto.response.UserResponse;
import com.lumina.academy.authuser.user.domain.User;

public interface UserMapper {


    User toEntity(RegisterUserRequest create);

    UserResponse toResponse(User user);
}
