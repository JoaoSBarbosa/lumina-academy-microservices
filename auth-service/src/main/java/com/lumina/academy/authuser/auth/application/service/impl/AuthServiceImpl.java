package com.lumina.academy.authuser.auth.application.service.impl;

import com.lumina.academy.authuser.auth.application.dto.request.ChangePasswordRequest;
import com.lumina.academy.authuser.auth.application.dto.request.RegisterUserRequest;
import com.lumina.academy.authuser.auth.application.service.AuthService;
import com.lumina.academy.authuser.shared.exception.BusinessException;
import com.lumina.academy.authuser.shared.exception.DuplicateResourceException;
import com.lumina.academy.authuser.shared.exception.MissingRequiredFieldException;
import com.lumina.academy.authuser.shared.exception.ResourceNotFoundException;
import com.lumina.academy.authuser.user.application.dto.response.UserResponse;
import com.lumina.academy.authuser.user.domain.User;
import com.lumina.academy.authuser.user.domain.enums.UserStatus;
import com.lumina.academy.authuser.user.domain.vo.Email;
import com.lumina.academy.authuser.user.domain.vo.Password;
import com.lumina.academy.authuser.user.infrastructure.persistence.UserRepository;
import com.lumina.academy.authuser.user.application.mapper.UserMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.UUID;

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
    public UserResponse register(RegisterUserRequest register) {
        try {
            logger.info("[insert] Iniciando cadastro do usuário: {}", register.getFirstName());

            validateDuplicateUser(register.getEmail(), register.getUserName());

            User entity = mapper.toEntity(register);

            entity.setStatus(UserStatus.ACTIVE);
            entity = userRepository.save(entity);
            logger.info("[insert] Usuário cadastrado com sucesso: {}", entity.getId());
            return mapper.toResponse(entity);
        } catch (DataIntegrityViolationException ex) {
            throw resolverDuplicateException(ex);
        }
    }


    @Override
    public boolean existsByUserNameOrEmail(String email, String username) {
        if (email == null || username == null)
            throw new MissingRequiredFieldException("Email e username são obrigatórios");
        Email emailVo = new Email(email);
        return userRepository.existsByUserNameOrEmail(emailVo, username);
    }

    @Override
    public void alterPassword(ChangePasswordRequest passwordRequest, UUID id) {

        validateChangePasswordRequest(passwordRequest);
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
        user.setPassword(Password.toPassword(passwordRequest.getPassword()));
        userRepository.save(user);

    }

    private void validateChangePasswordRequest(ChangePasswordRequest passwordRequest) {

        if (passwordRequest == null) throw new MissingRequiredFieldException("Request não informado.");
        if (passwordRequest.getPassword().equals(passwordRequest.getOldPassword()))
            throw new BusinessException("A nova senha deve ser diferente da senha atual");
    }

    private void validateDuplicateUser(String email, String userName) {
        var existingUser = existsByUserNameOrEmail(email, userName);
        if (existingUser) {
            logger.warn("Tentativa de cadastro com email/username já existente. email={}", email);
            throw new DuplicateResourceException("Email ou nome de usuário já cadastrado.");
        }
    }


    private DuplicateResourceException resolverDuplicateException(DataIntegrityViolationException ex) {
        String error = ex.getMostSpecificCause().getMessage();
        if (error.contains("tb_usuario_cpf_key")) return new DuplicateResourceException("CPF já cadastrado");
        if (error.contains("tb_usuario_email_key")) return new DuplicateResourceException("E-mail já cadastrado");
        if (error.contains("tb_usuario_nome_usuario_key"))
            return new DuplicateResourceException("Nome de usuário já cadastrado.");

        return new DuplicateResourceException("Já existe um registro com esses dados.");
    }

}
