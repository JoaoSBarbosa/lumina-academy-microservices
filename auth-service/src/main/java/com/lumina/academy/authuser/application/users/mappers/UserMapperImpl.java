package com.lumina.academy.authuser.application.users.mappers;

import com.lumina.academy.authuser.application.users.dtos.UserResponse;
import com.lumina.academy.authuser.application.users.dtos.UsersCreate;
import com.lumina.academy.authuser.domain.users.entities.Users;
import com.lumina.academy.authuser.domain.users.valueobjects.Cpf;
import com.lumina.academy.authuser.domain.users.valueobjects.Email;
import com.lumina.academy.authuser.domain.users.valueobjects.Password;
import org.springframework.stereotype.Component;

import javax.print.attribute.standard.NumberUp;

@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public Users toEntity(UsersCreate create) {
        if (create == null) return null;
        Users user = new Users();
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
    public UserResponse toResponse(Users user) {
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
                user.getBirthDate()
        );
    }
}
