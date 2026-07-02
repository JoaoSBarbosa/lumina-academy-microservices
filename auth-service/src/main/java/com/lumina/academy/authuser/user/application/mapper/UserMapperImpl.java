package com.lumina.academy.authuser.user.application.mapper;

import com.lumina.academy.authuser.auth.application.dto.request.RegisterUserRequest;
import com.lumina.academy.authuser.shared.api.PageResponse;
import com.lumina.academy.authuser.user.application.dto.response.UserResponse;
import com.lumina.academy.authuser.user.domain.User;
import com.lumina.academy.authuser.user.domain.vo.Cpf;
import com.lumina.academy.authuser.user.domain.vo.Email;
import com.lumina.academy.authuser.user.domain.vo.Password;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class UserMapperImpl implements UserMapper {


    private final RestClient.Builder builder;

    public UserMapperImpl(RestClient.Builder builder) {
        this.builder = builder;
    }

    @Override
    public User toEntity(RegisterUserRequest create) {
        if (create == null) return null;

        User user = new User();
        user.setUserName(create.getUserName());
        user.setFirstName(create.getFirstName());
        user.setLastName(create.getLastName());
        user.setEmail(Email.toEmail(create.getEmail()));
        user.setPassword(Password.toPassword(create.getPassword()));
        user.setCpf(Cpf.toCpf(create.getCpf()));
        user.setUserType(create.getUserType());
        user.setStatus(create.getStatus());


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
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }

    @Override
    public <T> PageResponse<T> from(Page<T> page) {

        return PageResponse.<T>builder()
                .content(page.getContent())
                .page(page.getNumber())
                .size(page.getSize())
                .totalElements((int) page.getTotalElements())
                .totalPages(page.getTotalPages())
                .first(page.isFirst())
                .last(page.isLast())
                .hasNext(page.hasNext())
                .hasPrevious(page.hasPrevious())
                .build();
    }
}
