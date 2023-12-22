package br.com.ecstech.messenger.util;

public class Constants {
    public static final String HEALTHCHECK_ROUTE = "/healthcheck";

    public static final String AUTH_BASE_PATH = "/auth";

    public static final String LOGIN_ROUTE = "/login";
    public static final String SIGNUP_ROUTE = "/signup";

    public static final String AUTH_ROUTES_PATTERN = String.format("%s/**", AUTH_BASE_PATH);
    public static final String USER_ROUTES_PATTERN = "/user/**";
    public static final String ADMIN_ROUTES_PATTERN = "/admin/**";

    public static final String USER_BASE_PATH = "/user";

    public static final String ADMIN_BASE_PATH = "/admin";

    public static final String INFO_PATH = "/info";
    public static final String ADMINS_PATH = "/admins";

    public static final String MESSAGES_PATH = "/messages";
    public static final String MESSAGES_PATTERN = "/messages/**";
}
