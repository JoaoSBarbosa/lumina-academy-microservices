package com.lumina.academy.authuser.shared.api;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ApiResponse<T> {

    private final int code;
    private final boolean success;
    private final String message;
    private final T data;

    public static <T> ApiResponse<T> success(T data) {
        return ApiResponse.<T>builder()
                .code(200)
                .success(true)
                .message("Ok")
                .data(data)
                .build();
    }

    public static <T> ApiResponse<T> success(T data, String message, int code) {
        return ApiResponse.<T>builder()
                .code(code)
                .success(true)
                .message(message)
                .data(data)
                .build();
    }

    public static <T> ApiResponse<T> failure(String message, int code) {
        return ApiResponse.<T>builder()
                .code(code)
                .success(false)
                .message(message)
                .data(null)
                .build();
    }
}
