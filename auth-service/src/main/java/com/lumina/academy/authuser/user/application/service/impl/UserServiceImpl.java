package com.lumina.academy.authuser.user.application.service.impl;

import com.lumina.academy.authuser.shared.exception.BusinessException;
import com.lumina.academy.authuser.shared.exception.ResourceNotFoundException;
import com.lumina.academy.authuser.user.application.dto.UserResponse;
import com.lumina.academy.authuser.user.mapper.UserMapper;
import com.lumina.academy.authuser.user.domain.User;
import com.lumina.academy.authuser.user.infrastructure.persistence.UserRepository;
import com.lumina.academy.authuser.user.application.service.UserService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

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
    public UserResponse update(User users) {
        var user = repository.save(users);
        return mapper.toResponse(user);
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
}
