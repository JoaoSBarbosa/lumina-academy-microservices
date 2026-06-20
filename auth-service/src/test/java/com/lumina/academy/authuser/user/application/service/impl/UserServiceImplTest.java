package com.lumina.academy.authuser.user.application.service.impl;


import com.lumina.academy.authuser.user.application.dto.request.UpdateUserRequest;
import com.lumina.academy.authuser.user.application.dto.response.UserResponse;
import com.lumina.academy.authuser.user.domain.User;
import com.lumina.academy.authuser.user.domain.enums.UserGender;
import com.lumina.academy.authuser.user.domain.enums.UserStatus;
import com.lumina.academy.authuser.user.domain.enums.UserType;
import com.lumina.academy.authuser.user.domain.vo.Cpf;
import com.lumina.academy.authuser.user.domain.vo.Email;
import com.lumina.academy.authuser.user.domain.vo.Password;
import com.lumina.academy.authuser.user.infrastructure.persistence.UserRepository;
import com.lumina.academy.authuser.user.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private UserMapper userMapper;
    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void shouldUpdateUserSucessFully() {

        // Arrange (Preparar dados)
        UUID id = UUID.randomUUID();

        // 1. Usuário como viria do banco
        User userBefore = new User();
        userBefore.setId(id);
        userBefore.setUserName("usuario.teste");
        userBefore.setFirstName("João");
        userBefore.setLastName("Silva");
        userBefore.setEmail(Email.toEmail("joao@ex.com"));
        userBefore.setCpf(Cpf.toCpf("43177854524"));
        userBefore.setPassword(Password.toPassword("senha123"));
        userBefore.setStatus(UserStatus.ACTIVE);
        userBefore.setUserType(UserType.USER);

        // 2. Requisição de update com novos dados
        UpdateUserRequest request = new UpdateUserRequest();
        request.setFirstName("José");
        request.setLastName("Santos");
        request.setEmail("jose@ex.com");
        request.setCpf("12345678900");
        request.setPhoneNumber("11987654321");
        request.setGender(UserGender.M);
        request.setUserType(UserType.ADMIN);
        request.setStatus(UserStatus.ACTIVE);

        // 3. getReferenceById retorna o usuário ANTES da atualização
        when(userRepository.getReferenceById(id)).thenReturn(userBefore);

        // 4. Chama save, retorna o usuário já atualizado
        when(userRepository.save(any(User.class))).thenAnswer(invocation -> {
            User updatedUser = invocation.getArgument(0);
            return updatedUser;
        });

        // Act
        UserResponse result = userService.update(request, id);

        // Assert
        assertNotNull(result);
        assertEquals("José", result.firstName());
        assertEquals("Santos", result.lastName());
        assertEquals("jose@ex.com", result.email());
        assertEquals("ADMIN", result.userType());

        verify(userRepository).getReferenceById(id);
        verify(userRepository).save(any(User.class));

    }

}
