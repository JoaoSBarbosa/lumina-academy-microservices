package com.lumina.academy.authuser.shared;

public final class ApiConstants {

    public static final String API_V1 = "/api/v1";
    public static final String USERS = API_V1 + "/users";
    public static final String ROLES = API_V1 + "/roles";
    public static final String AUTH = API_V1 + "/auth";

    public static final String BY_ID = "/{id}";
    public static final String BY_EMAIL = "/email/{email}";

    public static final String LOGIN = "/login";
    public static final String REFRESH = "/refresh";
    public static final String LOGOUT = "/logout";
}
