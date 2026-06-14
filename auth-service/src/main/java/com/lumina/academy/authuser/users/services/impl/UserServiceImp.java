package com.lumina.academy.authuser.users.services.impl;

import com.lumina.academy.authuser.exceptions.ResourceNotFoundException;
import com.lumina.academy.authuser.users.dtos.UserResponse;
import com.lumina.academy.authuser.users.dtos.UsersCreate;
import com.lumina.academy.authuser.users.mapper.UserMapper;
import com.lumina.academy.authuser.users.entity.Users;
import com.lumina.academy.authuser.users.entity.enums.UserStatus;
import com.lumina.academy.authuser.users.repository.UserRepository;
import com.lumina.academy.authuser.users.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository _repository;
    private final UserMapper _mapper;

    public UserServiceImp(UserRepository userRepositoryJpa, UserMapper mapper) {
        _repository = userRepositoryJpa;
        _mapper = mapper;
    }

    @Override
    public UserResponse findByEmail(String email) {
        return _repository.findByEmail(email)
                .map(_mapper::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado: " + email));
    }

    @Override
    public List<UserResponse> findAll() {
        return _repository.findAll().stream().map(_mapper::toResponse).toList();
    }

    @Override
    public UserResponse findById(UUID id) {
        return _repository.findById(id)
                .map(_mapper::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado: " + id));
    }

    @Override
    public UserResponse findByUsername(String username, String lastName) {
        return _repository.FindByNameAndLastName(username, lastName)
                .map(_mapper::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado: " + username + " " + lastName));
    }

    @Override
    public UserResponse insert(UsersCreate users) {
        var entity = _mapper.toEntity(users);

        entity.setStatus(UserStatus.ACTIVE);
        entity = _repository.save(entity);
        return _mapper.toResponse(entity);
    }

    @Override
    public UserResponse update(Users users) {
        var user = _repository.save(users);
        return _mapper.toResponse(user);
    }

    @Override
    public void delete(Users users) {

        _repository.delete(users);
    }
}
