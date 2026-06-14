package com.lumina.academy.authuser.users.mapper;

import com.lumina.academy.authuser.users.dtos.UserResponse;
import com.lumina.academy.authuser.users.dtos.UsersCreate;
import com.lumina.academy.authuser.users.entity.Users;

public interface UserMapper {

    Users toEntity(UsersCreate create);

    UserResponse toResponse(Users user);
}
