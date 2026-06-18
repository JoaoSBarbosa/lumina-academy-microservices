package com.lumina.academy.authuser.auth.service.impl;

import com.lumina.academy.authuser.auth.service.AuthService;
import com.lumina.academy.authuser.shared.exception.DuplicateResourceException;
import com.lumina.academy.authuser.shared.exception.MissingRequiredFieldException;
import com.lumina.academy.authuser.user.application.dto.UserCreateRequest;
import com.lumina.academy.authuser.user.application.dto.UserResponse;
import com.lumina.academy.authuser.user.domain.User;
import com.lumina.academy.authuser.user.domain.enums.UserStatus;
import com.lumina.academy.authuser.user.domain.vo.Email;
import com.lumina.academy.authuser.user.infrastructure.persistence.UserRepository;
import com.lumina.academy.authuser.user.mapper.UserMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserMapper mapper;
    private final UserRepository userRepository;

    private static final Logger logger = LogManager.getLogger(AuthServiceImpl.class);

    public AuthServiceImpl(UserMapper mapper, UserRepository userRepository) {
        this.mapper = mapper;
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse register(UserCreateRequest users) {

        logger.info("[insert] Iniciando cadastro do usuário: {}", users.getFirstName());

        validateDuplicateUser(users.getEmail(), users.getUserName());

        User entity = mapper.toEntity(users);

        entity.setStatus(UserStatus.ACTIVE);
        entity = userRepository.save(entity);
        logger.info("[insert] Usuário cadastrado com sucesso: {}", entity.getId());
        return mapper.toResponse(entity);

    }


    @Override
    public boolean existsByUserNameOrEmail(String email, String username) {
        if (email == null || username == null)
            throw new MissingRequiredFieldException("Email e username são obrigatórios");
        Email emailVo = new Email(email);
        return userRepository.existsByUserNameOrEmail(emailVo, username);
    }

    private void validateDuplicateUser(String email, String userName) {
        var existingUser = existsByUserNameOrEmail(email, userName);
        if (existingUser) {
            logger.warn("Tentativa de cadastro com email/username já existente. email={}", email);
            throw new DuplicateResourceException("Email ou nome de usuário já cadastrado.");
        }
    }


}
