package com.lumina.academy.authuser.user.application.service.impl;

import com.lumina.academy.authuser.shared.exception.BusinessException;
import com.lumina.academy.authuser.shared.exception.MissingRequiredFieldException;
import com.lumina.academy.authuser.shared.exception.ResourceNotFoundException;
import com.lumina.academy.authuser.user.application.dto.request.UpdateProfileImageRequest;
import com.lumina.academy.authuser.user.application.dto.request.UpdateUserRequest;
import com.lumina.academy.authuser.user.application.dto.response.UserResponse;
import com.lumina.academy.authuser.user.domain.vo.Cpf;
import com.lumina.academy.authuser.user.domain.vo.Email;
import com.lumina.academy.authuser.user.domain.vo.PhoneNumber;
import com.lumina.academy.authuser.user.application.mapper.UserMapper;
import com.lumina.academy.authuser.user.domain.User;
import com.lumina.academy.authuser.user.infrastructure.persistence.UserRepository;
import com.lumina.academy.authuser.user.application.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    public UserServiceImpl(UserRepository userRepositoryJpa, UserMapper mapper) {
        this.repository = userRepositoryJpa;
        this.mapper = mapper;
    }

    @Override
    public UserResponse findByEmail(String email) {
        return repository.findByEmail(email)
                .map(mapper::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado: " + email));
    }

    @Override
    public List<UserResponse> findAll(Pageable pageable, UUID userId) {

        return repository.findAll(pageable).stream().map(mapper::toResponse).toList();
    }

    @Override
    public UserResponse updateProfileImage(UpdateProfileImageRequest request, UUID userId) {
        if (request.getImageUrl() == null) throw new MissingRequiredFieldException("A URL da imagem é necessária");
        User user = repository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado: " + userId));

        user.setImageUrl(request.getImageUrl());
        user = repository.save(user);
        return mapper.toResponse(user);
    }

    @Override
    public UserResponse findById(UUID id) {
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado: " + id));
    }

    @Override
    public UserResponse findByUsername(String username, String lastName) {
        return repository.findByNameAndLastName(username, lastName)
                .map(mapper::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado: " + username + " " + lastName));
    }


    @Override
    public UserResponse update(UpdateUserRequest update, UUID id) {
        try {
            User user = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado: " + id));
            MapUpdateFields(update, user);

            user = repository.save(user);
            LOGGER.info("[SERVICE] Usuário atualizado com sucesso: {}", id);
            return mapper.toResponse(user);
        } catch (Exception ex) {
            throw new BusinessException("Erro ao tentar atualizar usuário | : " + ex.getMessage());
        }
    }

    @Override
    public void delete(UUID userId) {
        try {
            User user = repository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado: " + userId));
            repository.delete(user);
        } catch (Exception ex) {
            throw new BusinessException("Erro ao deletar usuário: " + userId + " | Erro: " + ex.getMessage());
        }
    }

    private void MapUpdateFields(UpdateUserRequest update, User user) {

        if (update.getFirstName() != null && !update.getFirstName().isBlank())
            user.setFirstName(update.getFirstName());

        if (update.getLastName() != null && !update.getLastName().isBlank())
            user.setLastName(update.getLastName());

        if (update.getEmail() != null && !update.getEmail().isBlank())
            user.setEmail(Email.toEmail(update.getEmail()));

        if (update.getCpf() != null && !update.getCpf().isBlank())
            user.setCpf(Cpf.toCpf(update.getCpf()));

        if (update.getStatus() != null)
            user.setStatus(update.getStatus());

        if (update.getUserType() != null)
            user.setUserType(update.getUserType());

        user.setPhoneNumber(PhoneNumber.toPhone(update.getPhoneNumber()));
        user.setBirthDate(update.getBirthDate());
        user.setGender(update.getGender());

    }
}
