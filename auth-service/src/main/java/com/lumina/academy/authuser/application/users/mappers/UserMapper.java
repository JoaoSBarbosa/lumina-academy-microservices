package com.lumina.academy.authuser.application.users.mappers;

import com.lumina.academy.authuser.application.users.dtos.UserResponse;
import com.lumina.academy.authuser.application.users.dtos.UsersCreate;
import com.lumina.academy.authuser.domain.users.entities.Users;

public interface UserMapper {

    Users toEntity(UsersCreate create);

    UserResponse toResponse(Users user);
}
