package com.lumina.academy.authuser.user.mapper;

import com.lumina.academy.authuser.user.application.dto.UserResponse;
import com.lumina.academy.authuser.user.application.dto.UserCreateRequest;
import com.lumina.academy.authuser.user.domain.User;
import com.lumina.academy.authuser.user.domain.vo.Cpf;
import com.lumina.academy.authuser.user.domain.vo.Email;
import com.lumina.academy.authuser.user.domain.vo.Password;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(UserCreateRequest create) {
        if (create == null) return null;
        User user = new User();
        user.setUserName(create.getUserName());
        user.setFirstName(create.getFirstName());
        user.setLastName(create.getLastName());
        user.setEmail(Email.toEmail(create.getEmail()));
        user.setPassword(Password.toPassword(create.getPassword()));
        user.setCpf(Cpf.toCpf(create.getCpf()));
        user.setUserType(create.getUserType());
        return user;
    }


    @Override
    public UserResponse toResponse(User user) {
        if (user == null) return null;

        return new UserResponse(
                user.getId(),
                user.getUserName(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail() != null ? user.getEmail().getValue() : null,
                user.getPhoneNumber() != null ? user.getPhoneNumber().getValue() : null,
                user.getCpf() != null ? user.getCpf().getValue() : null,
                user.getGender() != null ? user.getGender().name() : null,
                user.getImageUrl(),
                user.getStatus() != null ? user.getStatus().name() : null,
                user.getUserType() != null ? user.getUserType().name() : null,
                user.getBirthDate(),
                user.getPassword() != null ? user.getPassword().value() : null
        );
    }
}
