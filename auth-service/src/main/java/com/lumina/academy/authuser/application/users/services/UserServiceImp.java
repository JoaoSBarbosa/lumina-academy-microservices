package com.lumina.academy.authuser.application.users.services;

import com.lumina.academy.authuser.application.users.dtos.UserResponse;
import com.lumina.academy.authuser.application.users.dtos.UsersCreate;
import com.lumina.academy.authuser.application.users.mappers.UserMapper;
import com.lumina.academy.authuser.domain.users.entities.Users;
import com.lumina.academy.authuser.domain.users.enums.UserStatus;
import com.lumina.academy.authuser.infrastructure.persistence.users.UserRepositoryJpa;
import org.springframework.stereotype.Service;

import java.util.Enumeration;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImp implements UserService {

    private final UserRepositoryJpa _repository;
    private final UserMapper _mapper;

    public UserServiceImp(UserRepositoryJpa userRepositoryJpa, UserMapper mapper) {
        _repository = userRepositoryJpa;
        _mapper = mapper;
    }

    @Override
    public Optional<UserResponse> findByEmail(String email) {
        var users = _repository.findByEmail(email);
        return users.map(this._mapper::toResponse);
    }

    @Override
    public List<UserResponse> findAll() {
        return _repository.findAll().stream().map(_mapper::toResponse).toList();
    }

    @Override
    public Optional<UserResponse> findById(UUID id) {
        var users = _repository.findById(id);
        return users.map(this._mapper::toResponse);
    }

    @Override
    public Optional<UserResponse> findByUsername(String username, String lastName) {
        var user = _repository.FindByNameAndLastName(username, lastName);
        return user.map(this._mapper::toResponse);
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
