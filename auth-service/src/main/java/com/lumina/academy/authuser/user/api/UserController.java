package com.lumina.academy.authuser.user.api;


import com.lumina.academy.authuser.shared.api.ApiResponse;
import com.lumina.academy.authuser.shared.api.PageResponse;
import com.lumina.academy.authuser.user.application.dto.request.UpdateProfileImageRequest;
import com.lumina.academy.authuser.user.application.dto.request.UpdateUserRequest;
import com.lumina.academy.authuser.user.application.dto.response.UserResponse;
import com.lumina.academy.authuser.user.application.mapper.UserMapper;
import com.lumina.academy.authuser.user.application.mapper.UserMapperImpl;
import com.lumina.academy.authuser.user.application.service.UserService;
import com.lumina.academy.authuser.user.application.service.impl.UserServiceImpl;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/users")
public class UserController {


    private final UserService userService;
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<ApiResponse<PageResponse<UserResponse>>> findAll(
            @PageableDefault(
                    page = 0,
                    size = 100,
                    sort = "id",
                    direction = Sort.Direction.ASC
            ) Pageable pageable
    ) {
        Page<UserResponse> users = userService.findAll(pageable);
        PageResponse<UserResponse> pageResponse = PageResponse.from(users);
        return ResponseEntity.ok(ApiResponse.page(pageResponse));
    }


    @GetMapping("/{email}/email")
    public ResponseEntity<ApiResponse<UserResponse>> findUserByEmail(@RequestParam String email) {
        UserResponse user = userService.findByEmail(email);
        return ResponseEntity.ok(ApiResponse.success(user));
    }


    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponse>> getUserById(@PathVariable UUID id) {
        UserResponse user = userService.findById(id);
        return ResponseEntity.ok(ApiResponse.success(user));
    }


    @PutMapping("/{userId}")
    public ResponseEntity<ApiResponse<UserResponse>> updateUser(@RequestBody @Valid UpdateUserRequest request, @PathVariable UUID userId) {

        LOGGER.info("[API] Atualizando usuário com ID {}", userId);
        UserResponse response = userService.update(request, userId);
        return ResponseEntity.ok(ApiResponse.success(response));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse<Void>> deleteUser(@PathVariable UUID userId) {
        LOGGER.info("[API] Deletando usuário com ID {}", userId);
        userService.delete(userId);
        return ResponseEntity.ok(ApiResponse.success(null, "Usuário deletado com sucesso", HttpStatus.NO_CONTENT.value()));
    }


    @PutMapping("/{userId}/image")
    public ResponseEntity<ApiResponse<UserResponse>> updateProfileImage(
            @Valid @RequestBody UpdateProfileImageRequest request,
            @PathVariable UUID userId) {

        UserResponse response = userService.updateProfileImage(request, userId);
        return ResponseEntity.ok(ApiResponse.success(response));
    }

}
