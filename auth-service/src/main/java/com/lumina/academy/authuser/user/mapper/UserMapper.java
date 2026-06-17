package com.lumina.academy.authuser.user.mapper;

import com.lumina.academy.authuser.user.application.dto.UserResponse;
import com.lumina.academy.authuser.user.application.dto.UserCreateRequest;
import com.lumina.academy.authuser.user.domain.User;

public interface UserMapper {

    User toEntity(UserCreateRequest create);

    UserResponse toResponse(User user);
}
