package com.lumina.academy.authuser.user.application.service;

import com.lumina.academy.authuser.user.application.dto.request.UpdateUserRequest;
import com.lumina.academy.authuser.user.application.dto.response.UserResponse;
import com.lumina.academy.authuser.user.domain.User;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface UserService {

    UserResponse findByEmail(String email);

    UserResponse findById(UUID id);

    UserResponse findByUsername(String username, String lastName);

    List<UserResponse> findAll(Pageable pageable, UUID userId);


    UserResponse update(UpdateUserRequest users, UUID userId);

    void delete(UUID userId);
}
