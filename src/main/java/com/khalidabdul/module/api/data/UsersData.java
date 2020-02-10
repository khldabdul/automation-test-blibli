package com.khalidabdul.module.api.data;

import io.restassured.response.Response;

public class UsersData {

    private static String username;
    private static String password;

    private static String pageName;
    private static String displayType;
    private static String searchTermPrefix;
    private static String searchTerm;

    private static Response getPageResponse;
    private static Response postLoginResponse;

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        if (username.equalsIgnoreCase("null")) {
            UsersData.username = null;
        }else {
            UsersData.username = username;
        }
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        if (password.equalsIgnoreCase("null")) {
            UsersData.password = null;
        }else {
            UsersData.password = password;
        }
    }

    public static String getPageName() {
        return pageName;
    }

    public static void setPageName(String pageName) {
        UsersData.pageName = pageName;
    }

    public static String getDisplayType() {
        return displayType;
    }

    public static void setDisplayType(String displayType) {
        UsersData.displayType = displayType;
    }

    public static String getSearchTermPrefix() {
        return searchTermPrefix;
    }

    public static void setSearchTermPrefix(String searchTermPrefix) {
        UsersData.searchTermPrefix = searchTermPrefix;
    }

    public static String getSearchTerm() {
        return searchTerm;
    }

    public static void setSearchTerm(String searchTerm) {
        UsersData.searchTerm = searchTerm;
    }

    public static Response getGetPageResponse() {
        return getPageResponse;
    }

    public static void setGetPageResponse(Response getPageResponse) {
        UsersData.getPageResponse = getPageResponse;
    }

    public static Response getPostLoginResponse() {
        return postLoginResponse;
    }

    public static void setPostLoginResponse(Response postLoginResponse) {
        UsersData.postLoginResponse = postLoginResponse;
    }

}
