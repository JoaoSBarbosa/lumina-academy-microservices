package com.lumina.academy.course.shared.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private final int code;
    private final boolean success;
    private final String message;
    private final T data;

    @JsonCreator
    public ApiResponse(
            @JsonProperty("code") int code,
            @JsonProperty("success") boolean success,
            @JsonProperty("message") String message,
            @JsonProperty("data") T data) {
        this.code = code;
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<T>(200, true, "Ok", data);
    }

    public static <T> ApiResponse<T> success(String message, T data) {
        return new ApiResponse<T>(200, true, message, data);
    }

    public static <T> ApiResponse<T> success(String message, int code, T data) {
        return new ApiResponse<T>(code, true, message, data);
    }

    public static <T> ApiResponse<T> error(String message, int code) {
        return new ApiResponse<T>(code, false, message, null);
    }

    public static <T> ApiResponse<T> error(String message, int code, T data) {
        return new ApiResponse<T>(code, false, message, data);
    }

    public int getCode() {
        return code;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ApiResponse<?> that = (ApiResponse<?>) o;
        return code == that.code &&
                success == that.success &&
                Objects.equals(message, that.message) &&
                Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, success, message, data);
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "code=" + code +
                ", success=" + success +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}